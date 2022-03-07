package com.zensar.olx.bean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "olx_users")
public class OLXUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@NonNull
	@Column(name = "username")
	private String userName;

	@NonNull
	@Column(name = "password")
	private String password;

	@NonNull
	@Column(name = "roles")
	private String roles;

	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name = "active")
	private Active active;

	@Column(name = "firstname", nullable = true)
	private String firstName;

	@Column(name = "lastname", nullable = true)
	private String lastName;

	@NonNull
	@Column(name = "email")
	private String email;

	@NonNull
	@Column(name = "phone")
	private String phone;

	public OLXUser() {
		super();
	}

	public OLXUser(int id, String username, String password, String roles, Active active, String firstname,
			String lastname, String email, String phone) {
		super();
		this.id = id;
		this.userName = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phone = phone;
	}

	public OLXUser(String username, String password, String roles, Active active, String firstname, String lastname,
			String email, String phone) {
		super();
		this.userName = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phone = phone;
	}

	public OLXUser(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "OlxUsers [id=" + id + ", username=" + userName + ", password=" + password + ", roles=" + roles
				+ ", active=" + active + ", firstname=" + firstName + ", lastname=" + lastName + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof OLXUser))
			return false;
		OLXUser other = (OLXUser) obj;
		return id == other.id;
	}

}
