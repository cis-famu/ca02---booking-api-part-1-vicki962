package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hotel.entities.Hotel;
import com.hotel.entities.Room;
import com.hotel.respository.HotelRepository;
import com.hotel.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAllHotel() {

	
		// Pageable p = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
		List<Hotel> hotels = hotelRepository.findAll();
		return hotels;
	}

	@Override
	public Optional<Hotel> getHotelById(String id) {
		// TODO Auto-generated method stub
		Optional<Hotel> hotel = hotelRepository.findById(id);
		return hotel;
	}

	@Override
	public List<Hotel> getAllBySort(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findAll(Sort.by(Sort.Direction.ASC, id));
	}

	@Override
	public Hotel createHotel(Hotel hotel) {

		Hotel saveHotel = hotelRepository.save(hotel);
		return saveHotel;
	}

	@Override
	public void deleteHotelById(String id) {

		this.hotelRepository.deleteById(id);
	}

	@Override
	public Hotel update(Hotel hotel, String id) {

		Hotel hot = hotelRepository.findById(id).get();
		hot.setName(hotel.getName());
		hot.setType(hotel.getType());
		hot.setCity(hotel.getCity());
		hot.setAddress(hotel.getAddress());
		hot.setDistance(hotel.getDistance());
		hot.setPhoto(hotel.getPhoto());
		hot.setTitle(hotel.getTitle());
		hot.setRating(hotel.getRating());
		hot.setRooms((ArrayList<Room>) hotel.getRooms());
		hot.setCheapsetPrice(hotel.getCheapsetPrice());
		hot.setFeatured(hotel.isFeatured());
		hotelRepository.save(hot);

		return hot;
	}

}
