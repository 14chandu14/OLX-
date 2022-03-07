package com.zensar.olx.bean;

import java.time.LocalDate;

public class NewAdvertisementPostResponse {

	private int id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String userName;
	private String createdDate;
	private String modifiedDate;
	private String status;

	public NewAdvertisementPostResponse(int id, String title, double price, String category, String description,
			String userName, String createdDate, String modifiedDate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public NewAdvertisementPostResponse(String title, double price, String category, String description,
			String userName, String createdDate, String modifiedDate, String status) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public NewAdvertisementPostResponse(int id) {
		super();
		this.id = id;
	}

	public NewAdvertisementPostResponse() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String string) {
		this.createdDate = string;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String string) {
		this.modifiedDate = string;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NewAdvertisementPostResponse [id=" + id + ", title=" + title + ", price=" + price + ", category="
				+ category + ", description=" + description + ", userName=" + userName + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
	}

}
