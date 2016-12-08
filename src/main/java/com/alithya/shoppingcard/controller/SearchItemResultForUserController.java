package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SearchItemResultForUserController {

	@RequestMapping("showSearchItemResultForUser")
	public String showResult(HttpSession session, Model model, SessionStatus status) {
		model.addAttribute("result",session.getAttribute("itemsResult"));
		status.setComplete();
		return "showSearchItemResultForUser";
	}
}
