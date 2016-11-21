package idv.jmrs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.User;
import idv.jmrs.enums.Role;
import idv.jmrs.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	private User user;

	private List<User> userList = new ArrayList<User>();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("user-list");

		userList = userService.findAll(User.class);
		modelAndView.addObject("userList", userList);

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("user-addEdit");
		modelAndView.addObject(ACTION, ACTION_ADD);
		modelAndView.addObject("roles", Role.values());
		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(User user) {
		ModelAndView modelAndView = new ModelAndView("user-addEdit");
		modelAndView.addObject(ACTION, ACTION_EDIT);
		modelAndView.addObject("roles", Role.values());

		user = userService.findOne(User.class, user.getUserId());
		modelAndView.addObject("user", user);

		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");

		if (user != null) {
			userService.save(user);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");

		if (user != null) {
			userService.update(user);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");

		if (user != null) {
			userService.delete(User.class, user.getUserId());
		}

		return modelAndView;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
