package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.bean.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
	
}
