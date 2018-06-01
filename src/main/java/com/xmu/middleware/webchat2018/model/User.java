package com.xmu.middleware.webchat2018.model;

import java.math.BigInteger;

public class User {
	private BigInteger id;

	private String username;

	private String password;

	private String avatarLocation;
	public User(){}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", avatarLocation='" + avatarLocation + '\'' +
				'}';
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(BigInteger id, String username, String password, String avatarLocation) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarLocation = avatarLocation;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarLocation() {
		return avatarLocation;
	}

	public void setAvatarLocation(String avatarLocation) {
		this.avatarLocation = avatarLocation;
	}
}