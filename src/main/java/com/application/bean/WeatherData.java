package com.application.bean;

import java.util.ArrayList;

public class WeatherData {
	private String cod;
	private int message;
	private int cnt;
	private ArrayList<List> list;
	private City city;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public ArrayList<List> getList() {
		return list;
	}

	public void setList(ArrayList<List> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
