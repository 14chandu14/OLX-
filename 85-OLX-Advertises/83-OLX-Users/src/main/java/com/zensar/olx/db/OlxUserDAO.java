package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.bean.LoginUser;
import com.zensar.olx.bean.OLXUser;

@Repository
public interface OlxUserDAO extends JpaRepository<OLXUser, Integer> {

	OLXUser findByUserName(String userName);
	
}
