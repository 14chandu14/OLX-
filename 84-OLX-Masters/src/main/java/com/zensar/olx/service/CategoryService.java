package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.bean.Category;
import com.zensar.olx.db.CategoryDAO;


@Service
public class CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	public Category addCategory(Category category) {
		return this.categoryDAO.save(category);
	}
	
	public List<Category> getAllCategories(){
		return this.categoryDAO.findAll();
	}
	
	public Category findCategory(int id) {
		Optional<Category> optional;
		optional=this.categoryDAO.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

}
