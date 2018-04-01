package com.lehongtrang.inventory.inventory.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
 //Repositories injection
	
//Login mapping
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
//Listing all items
	@RequestMapping(value="/index", method = RequestMethod.GET)
		public String showItems(Model model){
		return "index";
		
	}
}
