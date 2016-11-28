package idv.jmrs.controller;

import java.text.SimpleDateFormat;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public abstract class BaseController {

	public final String ACTION = "action";
	public final String ACTION_ADD = "add";
	public final String ACTION_EDIT = "edit";
	
	public final SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
	
	protected String currentDay;
}
