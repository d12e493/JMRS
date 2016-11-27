package idv.jmrs.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Book;

@Controller
@Scope("prototype")
@RequestMapping("/book")
public class BookController extends BaseController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Book book) {
		ModelAndView modelAndView = new ModelAndView("book-addEdit");
		modelAndView.addObject(ACTION, ACTION_ADD);

		modelAndView.addObject("book", book);

		return modelAndView;
	}
}
