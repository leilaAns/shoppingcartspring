package com.alithya.shoppingcard.service;

import java.util.List;
import com.alithya.shoppingcard.entity.User;

public interface UserService {

	public List<User> getUserRoles();

	public String returnCorrectPage(String userRole);

}
