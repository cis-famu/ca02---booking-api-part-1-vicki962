package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hotel.entities.Room;
import com.hotel.entities.RoomNumber;
import com.hotel.respository.RoomRepository;
import com.hotel.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> getAllRoom() {

		List<Room> rooms = roomRepository.findAll();
		return rooms;
	}

	@Override
	public Optional<Room> getRoomById(String id) {
		// TODO Auto-generated method stub
		Optional<Room> room = roomRepository.findById(id);
		return room;
	}

	@Override
	public List<Room> getAllRoomBySort(String id) {
		// TODO Auto-generated method stub
		return roomRepository.findAll(Sort.by(Sort.Direction.ASC, id));
	}

	@Override
	public Room createRoom(Room room) {

		Room saveRoom = roomRepository.save(room);
		return saveRoom;
	}

	@Override
	public void deleteRoomById(String id) {

		this.roomRepository.deleteById(id);

	}

	@Override
	public Room update(Room room, String id) {
		
		Room saveRoom = roomRepository.findById(id).get();
		saveRoom.setTitle(room.getTitle());
		saveRoom.setPrice(room.getPrice());
		saveRoom.setMaxPeople(room.getMaxPeople());
		saveRoom.setRoomNumber((ArrayList<RoomNumber>) room.getRoomNumber());
		roomRepository.save(saveRoom);
		return saveRoom;
	}



}
