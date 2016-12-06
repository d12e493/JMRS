package idv.jmrs.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Book;
import idv.jmrs.entity.Room;
import idv.jmrs.service.BookService;
import idv.jmrs.service.RoomService;
import idv.jmrs.utils.DateUtils;
import idv.jmrs.utils.ValidationUtils;
import idv.jmrs.vo.Booking;
import idv.jmrs.vo.Booking.BookType;
import idv.jmrs.vo.RoomBooking;

/**
 * @author Davis Chen
 *
 */
@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	private final String startTime = "08:00";
	private final String endTime = "19:00";

	@Autowired
	private RoomService roomService;

	@Autowired
	private BookService bookService;

	private List<Room> roomList = new ArrayList<Room>();

	private List<Book> bookList = new ArrayList<Book>();

	@RequestMapping(value = { "/", "welcome" })
	public ModelAndView dashboard(ModelMap model, @RequestParam(name = "date", required = false) String date,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("dashboard");

		LOG.debug("-------currentDay-------- : " + currentDay);

		currentDay = date == null ? smt.format(new Date()) : date;

		modelAndView.addObject("currentDay", currentDay);

		// get all booking
		bookList = bookService.getBooks(currentDay);

		roomList = roomService.findAll(Room.class);

		Map<String, List<Booking>> timeBookMap = transferForRoomAndBook(roomList, bookList);

		modelAndView.addObject("timeBookMap", timeBookMap);
		modelAndView.addObject("roomList", roomList);

		return modelAndView;
	}

	@RequestMapping("/login")
	public String login(ModelMap model) {

		LOG.debug("login page");

		return "login";
	}

	private Map<Integer, Map<String, Book>> getRoomMap(List<Room> roomList, List<Book> bookList) {
		Map<Integer, Map<String, Book>> roomMap = new HashMap<Integer, Map<String, Book>>();

		bookList.forEach(b -> {
			int roomId = b.getRoom().getRoomId();
			if (roomMap.get(roomId) == null) {
				roomMap.put(roomId, new HashMap<String, Book>());
			}

			Map<String, Book> map = roomMap.get(roomId);
			map.put(DateUtils.timeFormat(b.getStartTime()), b);

			roomMap.put(roomId, map);
		});

		return roomMap;
	}

	private Map<String, List<Booking>> transferForRoomAndBook(List<Room> roomList, List<Book> bookList) {

		Map<String, List<Booking>> timeMap = new LinkedHashMap<String, List<Booking>>();

		Calendar start = DateUtils.getCalendar(startTime);
		Calendar end = DateUtils.getCalendar(endTime);

		Map<Integer, Map<String, Book>> roomMap = getRoomMap(roomList, bookList);

		Map<Integer, Integer> rowSpanMap = new HashMap<Integer, Integer>();

		while (end.after(start)) {

			String startTimeKey = DateUtils.TIME_FORMAT.format(start.getTime());

			List<Booking> bookingList = new ArrayList<Booking>();
			for (Room room : roomList) {
				Booking booking = new Booking();
				booking.setRoomId(room.getRoomId());

				if (rowSpanMap.get(room.getRoomId()) != null && rowSpanMap.get(room.getRoomId()) > 0) {
					booking.setType(BookType.NO_FILL);
					rowSpanMap.put(room.getRoomId(), rowSpanMap.get(room.getRoomId()) - 1);
					continue;
				}

				Map<String, Book> bookMap = roomMap.get(room.getRoomId());
				if (bookMap != null) {
					Book book = bookMap.get(startTimeKey);
					if (book != null) {
						booking = new Booking(book);
						rowSpanMap.put(room.getRoomId(), booking.getRowSpan() - 1);
					}
				}

				bookingList.add(booking);
			}

			timeMap.put(startTimeKey, bookingList);

			start.add(Calendar.MINUTE, 30);
		}

		return timeMap;
	}

	public String getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}

}
