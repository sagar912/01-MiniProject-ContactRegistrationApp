package com.sagar.entities;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CONTACTS_MASTER")
@Data
public class ContactEntity {

@Id
@SequenceGenerator(name="contact",sequenceName="contact_id_seq",allocationSize=1)
@GeneratedValue(generator="contact", strategy=GenerationType.SEQUENCE)
@Column(name="CONTACT_ID")
private int contactId;

@Column(name="CONTACT_NAME")
private String contactName;

@Column(name="CONTACT_EMAIL")
private String contactEmail;

@Column(name="CONTACT_NUMBER")
private long contactNumber;

@CreationTimestamp
@Column(name="CONTACT_CREATEDDATE",updatable=false)
@Temporal(TemporalType.DATE)
private Date createdDate;

@UpdateTimestamp
@Column(name="CONTACT_UPDATEDDATE",insertable=false)
@Temporal(TemporalType.DATE)
private Date updatedDate;

}
