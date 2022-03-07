package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.bean.AdvertisementPost;

@Repository
public interface AdvertisementPostDAO extends JpaRepository<AdvertisementPost, Integer> {

	
	
}
