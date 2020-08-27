package com.sagar.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.entities.ContactEntity;


public interface ContactRepo extends JpaRepository<ContactEntity, Serializable>{

}
