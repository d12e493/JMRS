package idv.jmrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.entity.Room;
import idv.jmrs.repository.RoomRepository;
import idv.jmrs.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl extends BaseServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public void insert(Room room) {
		roomRepository.save(room);
		System.out.println("room id : " + room.getRoomId());
	}

}
