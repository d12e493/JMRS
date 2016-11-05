package idv.mrbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = { "/", "/home" })
	public String dashboard(ModelMap model) {

		LOG.info("log in dashboard");

		return "dashboard";
	}

	@RequestMapping("/login")
	public String login(ModelMap model) {

		LOG.debug("login page");

		return "login";
	}

}
