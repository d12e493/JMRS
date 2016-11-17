package idv.jmrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idv.jmrs.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

}
