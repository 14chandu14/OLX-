package com.zensar.olx.bean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Category {

	@Column(name = "category_id")
	private int id;
	
	@Transient
	private String name;
	
	@Transient
	private String description;

	public Category() {
		super();
	}

	public Category(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Category(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		return id == other.id;
	}

}
