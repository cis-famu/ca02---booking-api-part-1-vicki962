package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hotel.entities.User;
import com.hotel.respository.UserRepository;
import com.hotel.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public Optional<User> getUserById(String id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	@Override
	public List<User> getAllUserBySort(String id) {
		// TODO Auto-generated method stub
		return userRepository.findAll(Sort.by(Sort.Direction.DESC, id));
	}

	@Override
	public User createUser(User user) {

		User saveUser = userRepository.save(user);
		return saveUser;
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}

	@Override
	public User update(User user, String id) {
		
		User saveUser = userRepository.findById(id).get();
		saveUser.setUsername(user.getUsername());
		saveUser.setEmail(user.getEmail());
		saveUser.setCountry(user.getCountry());
		saveUser.setImg(user.getImg());
		saveUser.setCity(user.getCity());
		saveUser.setPhone(user.getPhone());
		saveUser.setAdmin(user.isAdmin());
		userRepository.save(saveUser);
		return saveUser;
	}
	
	
}
