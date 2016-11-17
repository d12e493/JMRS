package web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.entity.Role;
import idv.jmrs.entity.Room;
import idv.jmrs.repository.RoleRepository;
import idv.jmrs.repository.RoomRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "classpath:application.xml" })
@TestPropertySource("classpath:application.properties")
@WebAppConfiguration
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository repository;

	@Autowired
	private RoomRepository roomRepository;

	@Test
	public void testQuery() {
		Role role = repository.findOne("ADMIN");
		System.out.println(role.getRoleId());
	}

	@Test
	public void insert() {
		Room room = new Room();
		room.setComment("comment");
		room.setName("test name");
		roomRepository.save(room);
		System.out.println("room id : " + room.getRoomId());
	}
}
