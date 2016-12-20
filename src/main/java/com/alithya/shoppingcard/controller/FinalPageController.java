package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.alithya.shoppingcard.statics.WebServiceStatics;

@Controller
public class FinalPageController {
	
	
	@RequestMapping(value = "/finalPage")
	public String showPage(HttpServletRequest request,Model model) {
		
		RestTemplate template = new RestTemplate();
	    ResponseEntity<Double> clientDoubleEntity = template.getForEntity(WebServiceStatics.GETBALANCE_URL_API,Double.class);
		 if(clientDoubleEntity.getStatusCodeValue() == 200)
			 model.addAttribute("balance", clientDoubleEntity.getBody().doubleValue());
		request.getSession().invalidate();
		return "finalPage";
	}

}
