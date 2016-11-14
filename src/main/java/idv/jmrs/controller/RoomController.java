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
	private RegionService regionService;

	@Autowired
	private RoomService roomService;

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
		modelAndView.addObject(ACTION, "add");
		return modelAndView;
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

}
