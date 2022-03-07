package com.zensar.olx.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "olx_adv_status")
public class AdvertisementStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	private String status;

	public AdvertisementStatus() {
		super();
	}

	public AdvertisementStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public AdvertisementStatus(String status) {
		super();
		this.status = status;
	}

	public AdvertisementStatus(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdvStatus [id=" + id + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AdvertisementStatus))
			return false;
		AdvertisementStatus other = (AdvertisementStatus) obj;
		return id == other.id;
	}

}
