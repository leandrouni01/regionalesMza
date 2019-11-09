package com.example.regionalesMza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String name;
	
	@Column(unique = true)
	private String cuit;
	
	@Column(unique = true)
	private String phone;
	
	private String catalog;
	
	private String full_addres;
	
	@Column(unique = true)
	private String latitude;
	
	@Column(unique = true)
	private String longitude;
		
	public Company() {
		
	}
	
	public Company(String name, String cuit, String phone, String catalog ,String full_addres, String latitude, String longitude) {
		this.name = name;
		this.cuit = cuit;
		this.phone = phone;
		this.catalog = catalog;
		this.full_addres = full_addres;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	
}
