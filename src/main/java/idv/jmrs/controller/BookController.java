package idv.jmrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import idv.jmrs.entity.Book;
import idv.jmrs.entity.User;
import idv.jmrs.service.BookService;

@Controller
@Scope("prototype")
@RequestMapping("/book")
public class BookController extends BaseController {

	@Autowired
	private BookService bookService;

	private Book book;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Book book) {
		ModelAndView modelAndView = new ModelAndView("book-addEdit");
		modelAndView.addObject(ACTION, ACTION_ADD);

		modelAndView.addObject("book", book);

		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Book book) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");

		if (!validateBooking(book)) {
			return add(book);
		}
		book.setUser(new User(1));

		countMinuteAndHour(book);

		bookService.save(book);

		modelAndView.addObject("currentDay", smt.format(book.getBookDate()));

		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Book book) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");

		if (!validateBooking(book)) {
			return edit(book.getBookId());
		}
		book.setUser(new User(1));

		countMinuteAndHour(book);

		bookService.update(book);

		modelAndView.addObject("currentDay", smt.format(book.getBookDate()));

		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(@RequestParam("bookId") Integer bookId) {
		ModelAndView modelAndView = new ModelAndView("book-addEdit");
		modelAndView.addObject(ACTION, ACTION_EDIT);

		book = bookService.findOne(Book.class, bookId);

		modelAndView.addObject("book", book);

		return modelAndView;
	}

	private void countMinuteAndHour(Book book) {
		if (book.getStartTime() != null && book.getEndTime() != null) {
			long duration = book.getEndTime().getTime() - book.getStartTime().getTime();
			int minutes = (int) (duration / 1000 / 60);
			double hours = (double) minutes / 60;

			book.setMinutes(minutes);
			book.setHours(hours);
		}
	}

	private boolean validateBooking(Book book) {

		// 檢查必填
		if (StringUtils.isEmpty(book.getName())) {
			return false;
		}

		// 檢查時間衝突
		if (book.getStartTime() != null && book.getEndTime() != null) {

		}

		return true;
	}
}
