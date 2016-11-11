package idv.jmrs.repository;

import org.springframework.data.repository.CrudRepository;

import idv.jmrs.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
