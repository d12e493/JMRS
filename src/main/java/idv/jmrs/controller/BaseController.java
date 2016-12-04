package idv.jmrs.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import idv.jmrs.Application;
import idv.jmrs.vo.Message;

@EnableWebMvc
public abstract class BaseController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private Application application;

	public final String ACTION = "action";
	public final String ACTION_ADD = "add";
	public final String ACTION_EDIT = "edit";

	public final SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");

	protected String currentDay;
	protected List<Message> messageList = new ArrayList<Message>();

	protected void addMessage(String code) {
		String content = application.messageSource().getMessage(code, null, Application.locale);
		String type = "info";
		String icon = "";
		if (code.startsWith("SUC_")) {
			type = "success";
			icon = "glyphicon glyphicon-ok-sign";
		} else if (code.startsWith("ERR_")) {
			type = "danger";
			icon = "glyphicon glyphicon-minus-sign";
		} else if (code.startsWith("WAR_")) {
			type = "warning";
			icon = "glyphicon glyphicon-warning-sign";
		} else if (code.startsWith("INF_")) {
			type = "info";
			icon = "glyphicon glyphicon-info-sign";
		}
		Message message = new Message(code, content, type);
		message.setIcon(icon);
		messageList.add(message);
		httpSession.setAttribute("messages", messageList);
	}
}
