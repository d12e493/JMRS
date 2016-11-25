package idv.jmrs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	private String currentDay;

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
