package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.olx.bean.AdvertisementPost;
import com.zensar.olx.db.AdvertisementPostDAO;

@Service
public class AdvertisementPostService {

	@Autowired
	AdvertisementPostDAO dao;

	public AdvertisementPost addAdvertisementPost(AdvertisementPost advertisementPost) {
		return this.dao.save(advertisementPost);
	}

	public AdvertisementPost updateAdvertisementPost(AdvertisementPost advertisementPost) {
		return this.dao.save(advertisementPost);
	}

	public List<AdvertisementPost> getAllAdvertisementPosts() {
		return this.dao.findAll();
	}

	public boolean deleteAdvertisementPost(AdvertisementPost advertisementPost) {
		boolean result = false;
		try {
			this.dao.delete(advertisementPost);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public AdvertisementPost getAdvertisementById(int id) {
		Optional<AdvertisementPost> optional;
		optional=dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
}
