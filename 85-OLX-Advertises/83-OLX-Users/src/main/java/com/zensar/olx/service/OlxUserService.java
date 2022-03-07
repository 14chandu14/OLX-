package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.db.OlxUserDAO;

@Service
public class OlxUserService {
	
	@Autowired
	OlxUserDAO olxUserDAO;
	
	public OLXUser addOlxUser(OLXUser olxUser) {
		return this.olxUserDAO.save(olxUser);
	}
	
	public OLXUser updateOlxUser(OLXUser olxUser) {
		return this.olxUserDAO.save(olxUser);
	}
	
	public OLXUser findOlxUser(int id) {
		Optional<OLXUser> olxUser=this.olxUserDAO.findById(id);
		if(olxUser.isPresent())
			return olxUser.get();
		else
			return null;
	}
	
	public OLXUser findOlxUserByName(String name) {
		OLXUser olxUser=this.olxUserDAO.findByUserName(name);
		return olxUser;
	}
	
	public List<OLXUser> getAllUsers() {
		
		return this.olxUserDAO.findAll();
		
	}
}
