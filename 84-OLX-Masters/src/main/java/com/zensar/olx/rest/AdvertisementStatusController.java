package com.zensar.olx.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.bean.AdvertisementStatus;
import com.zensar.olx.service.AdvertisementStatusService;

@RestController
public class AdvertisementStatusController {

	@Autowired
	AdvertisementStatusService service;

	@PostMapping("/advertise/add")
	public AdvertisementStatus addAdvertisementStatus(@RequestBody AdvertisementStatus advertisementStatus) {
		return this.service.addAdvertisementStatus(advertisementStatus);
	}

	@GetMapping("/advertise/status")
	public List<AdvertisementStatus> getAdvertisementStatus() {
		return this.service.getAdvertisementStatus();
	}
	
	@GetMapping("/advertisementStatus/getStatus/{id}")
	public AdvertisementStatus getAdvertisementStatus(@PathVariable(name = "id") int id) {
		return this.service.findAdvertisementStatus(id);
	}

}
