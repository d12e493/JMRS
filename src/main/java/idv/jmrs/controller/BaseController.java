package idv.jmrs.controller;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public abstract class BaseController {

	public final String ACTION = "action";
	public final String ACTION_ADD = "add";
	public final String ACTION_EDIT = "edit";
}
