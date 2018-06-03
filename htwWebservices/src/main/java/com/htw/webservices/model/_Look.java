package com.htw.webservices.model;

import java.util.Date;

public class Look {
	private int id;
	private String img;
	private Date dateCreate;

	public Look() {
	}

	public Look(int id, String img, Date dateCreate) {
		this.id = id;
		this.img = img;
		this.dateCreate = dateCreate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
