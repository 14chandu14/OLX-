package com.zensar.olx.bean;

public class LoginUser {

	private String userName;
	private String password;

	public LoginUser() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public LoginUser(String userName) {
		super();
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LoginUser [userName=" + userName + ", password=" + password + "]";
	}

}
