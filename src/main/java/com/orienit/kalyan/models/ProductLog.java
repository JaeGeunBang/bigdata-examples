package com.orienit.kalyan.models;

import com.google.gson.JsonObject;

public class ProductLog {

	long userid;
	String username;
	String email;
	String date;
	String product;
	String transaction;
	String country;
	String state;
	String city;

	public ProductLog(long userid, String username, String email, String date, String product, String transaction,
			String country, String state, String city) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.date = date;
		this.product = product;
		this.transaction = transaction;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		JsonObject jo = new JsonObject();
		jo.addProperty("userid", userid);
		jo.addProperty("username", username);
		jo.addProperty("email", email);
		jo.addProperty("date", date);
		jo.addProperty("product", product);
		jo.addProperty("transaction", transaction);
		jo.addProperty("country", country);
		jo.addProperty("state", state);
		jo.addProperty("city", city);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
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

}
