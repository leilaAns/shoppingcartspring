package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {


	@RequestMapping(value = "/userFirstPage")
	public String goHomeUserPage(){	
		return "userFirstPage";
	}
	
	
	@RequestMapping(value ="/adminFirstPage")
	public String goHomeAdminPage() {		
		return "adminFirstPage";
	}
	
	@RequestMapping(value = "/")
	public String goHomePage(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String destination = "welcome";
		 if (!auth.getName().equals("anonymousUser")){    
		   destination = (auth.getName() + "FirstPage").trim();
		 }
		return destination;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}
