package com.hotel.service;

import java.util.List;
import java.util.Optional;
import com.hotel.entities.Room;

public interface RoomService {

	List<Room> getAllRoom();

	Optional<Room> getRoomById(String id);

	List<Room> getAllRoomBySort(String id);

	public Room createRoom(Room room);

	public void deleteRoomById(String id);

	public Room update(Room room, String id);
}
