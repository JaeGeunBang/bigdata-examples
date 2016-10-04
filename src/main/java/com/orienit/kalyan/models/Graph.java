package com.orienit.kalyan.models;

import com.google.gson.JsonObject;

public class Graph {
	String name;
	long count;
	String color;

	public Graph(String name, long count, String color) {
		this.name = name;
		this.count = count;
		this.color = color;
	}

	@Override
	public String toString() {
		JsonObject jo = new JsonObject();
		jo.addProperty("name", name);
		jo.addProperty("count", count);
		jo.addProperty("color", color);
		return jo.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
