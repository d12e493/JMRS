package idv.jmrs.repository;

import org.springframework.data.repository.CrudRepository;

import idv.jmrs.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
