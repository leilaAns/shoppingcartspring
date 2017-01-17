package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ReceiptController {
	
	
	@RequestMapping(value = "/receipt")
	public String showPage(HttpServletRequest request) {

		request.getSession().invalidate();
		return "receipt";
	}

}
