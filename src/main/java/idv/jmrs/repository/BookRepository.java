package idv.jmrs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import idv.jmrs.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	List<Book> findByBookDate(Date date);
}
