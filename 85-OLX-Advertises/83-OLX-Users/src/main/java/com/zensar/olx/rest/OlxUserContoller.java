package com.zensar.olx.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.service.OlxUserService;

@RestController
public class OlxUserContoller {

	@Autowired
	OlxUserService olxUserService;

	@PostMapping("/user")
	public OLXUser addOlxUser(@RequestBody OLXUser olxUser) {
		return this.olxUserService.addOlxUser(olxUser);
	}

	@GetMapping("/user/{uid}")
	public OLXUser findOlxUserById(@PathVariable(name = "uid") int id) {
		return this.olxUserService.findOlxUser(id);
	}

	@GetMapping("/user/find/{userName}")
	public OLXUser findOlxUserByName(@PathVariable(name = "userName") String name) {
		return this.olxUserService.findOlxUserByName(name);
	}
	

}
