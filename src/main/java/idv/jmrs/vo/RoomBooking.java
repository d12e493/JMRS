package idv.jmrs.vo;

import java.util.ArrayList;
import java.util.List;

public class RoomBooking {
	private Integer id;
	private String name;
	private List<Booking> bookingList = new ArrayList<Booking>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	@Override
	public String toString() {
		return "RoomBooking [id=" + id + ", name=" + name + ", bookingList=" + bookingList + "]";
	}
}
