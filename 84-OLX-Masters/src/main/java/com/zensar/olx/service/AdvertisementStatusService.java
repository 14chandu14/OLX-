package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.olx.bean.AdvertisementStatus;
import com.zensar.olx.db.AdvertisementStatusDAO;


@Service
public class AdvertisementStatusService {
	
	@Autowired
	AdvertisementStatusDAO dao;
	
	
	public AdvertisementStatus addAdvertisementStatus(AdvertisementStatus advertisementStatus) {
		return this.dao.save(advertisementStatus);
	}
	
	public List<AdvertisementStatus> getAdvertisementStatus(){
		return this.dao.findAll();
	}
	
	public AdvertisementStatus findAdvertisementStatus(int id) {
		Optional<AdvertisementStatus> optional;
		optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

}
