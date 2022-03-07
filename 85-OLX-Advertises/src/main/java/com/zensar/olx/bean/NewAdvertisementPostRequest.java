package com.zensar.olx.bean;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;


public class NewAdvertisementPostRequest {

	private int id;
	private String title;
	private int categoryId;
	private String description;
	private double price;
	private int statusId;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public NewAdvertisementPostRequest(String title, int categoryId, String description, double price) {
		super();
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
	}

	public NewAdvertisementPostRequest(int id, String title, int categoryId, String description, double price) {
		super();
		this.id = id;
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
	}

	public NewAdvertisementPostRequest(int id) {
		super();
		this.id = id;
	}

	public NewAdvertisementPostRequest() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NewAdvertisementPostRequest [id=" + id + ", title=" + title + ", categoryId=" + categoryId
				+ ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NewAdvertisementPostRequest))
			return false;
		NewAdvertisementPostRequest other = (NewAdvertisementPostRequest) obj;
		return id == other.id;
	}

}
