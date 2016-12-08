package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alithya.shoppingcard.entity.User;
import com.alithya.shoppingcard.service.UserService;


@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping({ "home", "/adminFirstPage", "/userFirstPage" })
	public String goHome(@ModelAttribute User user) {
		String destination = "";
		if (user.getRole() != null && user.getRole() != "") {
			if (user.getRole().equals("admin")) {
				destination = "adminFirstPage";
			} else if (!user.getRole().equals("admin")) {
				destination = "userFirstPage";
			}
		} else
			destination = "home";
		
		System.out.println(userService.getUserRoles());
		
		return destination;
	}

}
