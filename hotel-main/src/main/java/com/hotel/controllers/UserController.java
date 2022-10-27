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
import com.hotel.entities.User;
import com.hotel.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService useService;

	@GetMapping("/user/")
	public List<User> getAllUser() {
		List<User> list = useService.getAllUser();
		return list;
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		Optional<User> user = useService.getUserById(id);

		return user;
	}

	@GetMapping("/user/")
	public List<User> getAllUserTheSort(@RequestParam(value = "sort", required = false) String asc) {
		List<User> allUser = useService.getAllUserBySort(asc);
		return allUser;
	}

	@PostMapping("/user/")
	public User createUser(@RequestBody User user) {

		User saveUser = useService.createUser(user);
		return saveUser;
	}

	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") String id) {
		this.useService.deleteUserById(id);
	}

	@PutMapping("/user/{id}")
	public User update(@RequestBody User user, @PathVariable("id") String id) {
		User update = useService.update(user, id);
		return update;
	}

}
