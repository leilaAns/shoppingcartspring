package com.alithya.shoppingcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alithya.shoppingcard.entity.User;

@Controller
public class HomeController {

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
		return destination;
	}

}
