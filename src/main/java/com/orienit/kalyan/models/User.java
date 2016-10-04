package com.orienit.kalyan.models;

import com.google.gson.JsonObject;

public class User {
	long userid;
	String username;
	String password;
	String email;
	String country;
	String state;
	String city;
	String date;

	public User(long userid, String username, String password, String email, String country, String state, String city,
			String date) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.date = date;
	}

	@Override
	public String toString() {
		JsonObject jo = new JsonObject();
		jo.addProperty("userid", userid);
		jo.addProperty("username", username);
		jo.addProperty("password", password);
		jo.addProperty("email", email);
		jo.addProperty("country", country);
		jo.addProperty("state", state);
		jo.addProperty("city", city);
		jo.addProperty("date", date);
		return jo.toString();
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
