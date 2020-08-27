package com.sagar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.model.Contact;
import com.sagar.services.ContactService;


@Controller
public class ViewContactsController {
	@Autowired
	private ContactService service;
	
//=======================================Update Contact ===============================================================//updateContact
	   @GetMapping("/updateContact")
	   public String updateContacts(@RequestParam("cid")int contactId,Model model) {
		   Contact contactById = service.getContactById(contactId);
		   model.addAttribute("contact",contactById);
		   return "contactInfo";
	   }
	
//=======================================Delete Contact ===============================================================//
	   @GetMapping("/deleteContact")
	   public String deleteContacts(@RequestParam("ccid")int contactId,Model model) {
		  service.deleteContact(contactId);
		   return "redirect:viewAllContacts";
	   }   
   }

