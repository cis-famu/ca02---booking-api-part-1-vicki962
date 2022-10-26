package com.hotel.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.entities.Room;
import com.hotel.service.RoomService;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/room")
	public List<Room> getAllRoom() {

		List<Room> list = roomService.getAllRoom();
		return list;
	}

	@GetMapping("/room/{id}")
	public Optional<Room> getRoomById(@PathVariable("id") String id) {
		Optional<Room> room = roomService.getRoomById(id);
		return room;
	}

	@GetMapping("/room/")
	public List<Room> getAllRoomTheSort(@RequestParam(value = "sort", required = false) String asc) {
		List<Room> allRoom = roomService.getAllRoomBySort(asc);
		return allRoom;
	}

	@PostMapping("/room/")
	public Room createRoom(@RequestBody Room room) {

		Room saveRoom = roomService.createRoom(room);
		return saveRoom;
	}

	@DeleteMapping("/room/{id}")
	public void deleteRoomById(@PathVariable("id") String id) {
		this.roomService.deleteRoomById(id);
	}

	@PutMapping("/room/{id}")
	public Room update(@RequestBody Room room, @PathVariable("id") String id) {
		Room update = roomService.update(room, id);
		return update;
	}
}
