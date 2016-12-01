package idv.jmrs.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.entity.Book;
import idv.jmrs.repository.BookRepository;
import idv.jmrs.service.BookService;
import idv.jmrs.utils.DateUtils;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBooks(String date) {
		Date d = new Date();
		try {
			d = DateUtils.smt.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return bookRepository.findByBookDate(d);
	}

}
