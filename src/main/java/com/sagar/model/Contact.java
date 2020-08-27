package com.sagar.model;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private int contactId;
	private String contactName;
	private String contactEmail;
	private long contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
