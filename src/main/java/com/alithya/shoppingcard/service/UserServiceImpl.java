package com.alithya.shoppingcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.User;
import com.alithya.shoppingcard.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUserRoles() {
		return userRepository.getRoles();
	}

}
