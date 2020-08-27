package com.sagar.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.entities.ContactEntity;
import com.sagar.model.Contact;
import com.sagar.repositories.ContactRepo;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactrepo;

	@Override
	public boolean saveContact(Contact c) {

		ContactEntity contactEntity =new ContactEntity();
		BeanUtils.copyProperties(c, contactEntity);
		ContactEntity contactE = contactrepo.save(contactEntity);
		
		return contactE !=null;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<ContactEntity> entitylist = contactrepo.findAll();
		
		return entitylist.stream().map(entity ->{
			
			Contact contact =new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
	}
	
//--------------------------------------------------------------//
	@Override
	public Contact getContactById(Integer cid) {
 
	    Contact contact= new Contact();
	    Optional<ContactEntity> findById = contactrepo.findById(cid);
	    if(findById.isPresent()) {
	    ContactEntity contactEntity = findById.get();
	    BeanUtils.copyProperties(contactEntity, contact);
		return contact;
	    }
	    else {
	    	return null;
	    }
	}

//==================================================//	
	@Override
	public boolean deleteContact(Integer contactid) {

	    contactrepo.deleteById(contactid);
			
		return true;
	}
	
}
