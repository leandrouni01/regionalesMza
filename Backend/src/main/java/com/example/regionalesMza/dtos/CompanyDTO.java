package com.example.regionalesMza.dtos;

import java.io.Serializable;

public class CompanyDTO implements Serializable{

	private int id;
	private String name;
	private String cuit;
	private String phone;
	private String full_addres;
	private String latitude;
	private String longitude;
	
	
	
	public CompanyDTO() {
		
	}

	public CompanyDTO(String name, String cuit, String phone, String full_addres, String latitude, String longitude) {
		this.name = name;
		this.cuit = cuit;
		this.phone = phone;
		this.full_addres = full_addres;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFull_addres() {
		return full_addres;
	}

	public void setFull_addres(String full_addres) {
		this.full_addres = full_addres;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
	
}
