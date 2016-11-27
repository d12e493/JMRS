package idv.jmrs.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Room;
import idv.jmrs.service.RoomService;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RoomService roomService;

	private String currentDay;

	private List<Room> roomList = new ArrayList<Room>();

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView dashboard(ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("dashboard");

		LOG.info("log in dashboard");

		LOG.info("-------currentDay-------- : " + currentDay);

		if (currentDay == null) {
			SimpleDateFormat smt = new SimpleDateFormat("yyyy/MM/dd");
			currentDay = smt.format(new Date());
		}
		modelAndView.addObject("currentDay", currentDay);

		roomList = roomService.findAll(Room.class);
		modelAndView.addObject("roomList", roomList);
		
		return modelAndView;
	}

	@RequestMapping("/login")
	public String login(ModelMap model) {

		LOG.debug("login page");

		return "login";
	}

	public String getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}

}
