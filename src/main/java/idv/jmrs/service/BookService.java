package idv.jmrs.service;

import java.util.List;

import idv.jmrs.entity.Book;

public interface BookService extends BaseService {

	List<Book> getBooks(String date);
}
