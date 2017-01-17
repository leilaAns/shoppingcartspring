package com.alithya.shoppingcard.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.alithya.shoppingcard.entity.DefaultItem;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class CreateNewItemController {

	@Autowired
	private ItemService<?> itemService;

	@RequestMapping(value = "/createNewItem")
	public ModelAndView showPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", itemService.createItem());
		modelAndView.setViewName("createNewItem");
		modelAndView.getModel();
		return modelAndView;
	}

	@RequestMapping(value = "/createNewItem", method = RequestMethod.POST)
	public String showAllItems(@ModelAttribute DefaultItem item){
		itemService.addNewItem(item);
		return "redirect:/adminShowAllItems";
	}

}
