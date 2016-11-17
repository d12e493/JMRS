package idv.jmrs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Region;
import idv.jmrs.entity.Room;
import idv.jmrs.service.RegionService;
import idv.jmrs.service.RoomService;

@Controller
@Scope("prototype")
@RequestMapping("/room")
public class RoomController extends BaseController {

	@Autowired
	private RoomService roomService;

	private Room room;

	private List<Region> regionList = new ArrayList<Region>();

	private List<Room> roomList = new ArrayList<Room>();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("room-list");

		roomList = roomService.findAll(Room.class);
		modelAndView.addObject("roomList", roomList);

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("room-addEdit");
		modelAndView.addObject(ACTION, ACTION_ADD);
		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(Room room) {
		ModelAndView modelAndView = new ModelAndView("room-addEdit");
		modelAndView.addObject(ACTION, ACTION_EDIT);

		room = roomService.findOne(Room.class, room.getRoomId());
		modelAndView.addObject("room", room);

		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Room room) {
		ModelAndView modelAndView = new ModelAndView("redirect:/room/list");

		if (room != null) {
			roomService.insert(room);
		}

		return modelAndView;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
