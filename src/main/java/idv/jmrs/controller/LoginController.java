package idv.jmrs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Book;
import idv.jmrs.entity.Room;
import idv.jmrs.service.BookService;
import idv.jmrs.service.RoomService;
import idv.jmrs.utils.DateUtils;
import idv.jmrs.utils.ValidationUtils;

/**
 * @author Davis Chen
 *
 */
@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RoomService roomService;

	@Autowired
	private BookService bookService;

	private List<Room> roomList = new ArrayList<Room>();

	private List<Book> bookList = new ArrayList<Book>();

	/**
	 * Map<room id , TreeMap < startTime , Book >>
	 */
	private Map<Integer, TreeMap<String, Book>> roomBookMap = new HashMap<Integer, TreeMap<String, Book>>();

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView dashboard(ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("dashboard");

		LOG.debug("-------currentDay-------- : " + currentDay);

		if (currentDay == null) {
			currentDay = smt.format(new Date());
		}
		modelAndView.addObject("currentDay", currentDay);

		// get all booking
		bookList = bookService.getBooks(currentDay);

		roomList = roomService.findAll(Room.class);

		roomBookMap = transferRoomAndBook(roomList, bookList);

		modelAndView.addObject("roomBookMap", roomBookMap);
		modelAndView.addObject("roomList", roomList);

		return modelAndView;
	}

	@RequestMapping("/login")
	public String login(ModelMap model) {

		LOG.debug("login page");

		return "login";
	}

	private Map<Integer, TreeMap<String, Book>> transferRoomAndBook(List<Room> roomList, List<Book> bookList) {
		Map<Integer, TreeMap<String, Book>> roomBookMap = new HashMap<Integer, TreeMap<String, Book>>();

		if (ValidationUtils.CheckListIsNotEmpty(roomList)) {
			roomList.forEach(r -> roomBookMap.put(r.getRoomId(), new TreeMap<String, Book>()));

			if (ValidationUtils.CheckListIsNotEmpty(bookList)) {
				bookList.forEach(b -> {

					int roomId = b.getRoom().getRoomId();

					TreeMap<String, Book> bookMap = roomBookMap.get(roomId);
					if (bookMap != null) {
						bookMap.put(DateUtils.timeFormat(b.getStartTime()), b);
						roomBookMap.put(roomId, bookMap);
					}
				});
			}
		}

		return roomBookMap;
	}

	public String getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}

}
