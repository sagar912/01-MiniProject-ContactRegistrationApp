package com.sagar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sagar.model.Contact;
import com.sagar.services.ContactService;


@Controller
public class ContactRegistrationController {
	@Autowired
	private ContactService service;
	
//===================================== Load Contact Form===============================================================//
	@GetMapping(value= {"/","/registerContact"})
	public String loadForm(Contact contact,Model model) {
		model.addAttribute("contact",contact);
		return "contactInfo";
	}
//================================ Save Contact ====================================================================//
   @PostMapping("/registerContact")
public String submit(@ModelAttribute("contact") Contact contact,Model model){
	   
	  service.saveContact(contact);
  	  model.addAttribute("SaveMsg", "Contact Added to PhoneBook Successfully....");
  	  return "redirect:registerContact";
  
	
   }
	
//===================================Redirection Concept ===================================================================//
	  
	  @GetMapping("/addContactSuccess") public String addsuccess(Model model){
	  
	  model.addAttribute("SaveMsg", "Contact Added Successfully.....!!!");
	  return "contactAddtionsSuccess"; 
	  }
	 
   
//=======================================View All Books ===============================================================//
   @GetMapping("/viewAllContacts")
   public String getAllContacts(Model model) {
	   List<Contact> alist = service.getAllContacts();
	   model.addAttribute("list", alist);
	   return "viewContactsdetails";
   }
   
 
}