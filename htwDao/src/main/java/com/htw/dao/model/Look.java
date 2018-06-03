package com.htw.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Look implements Serializable {

	private static final long serialVersionUID = -8710052231804094981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String img;

	@OneToMany(mappedBy = "article")
	private Set<LookArticles> articles = new HashSet<LookArticles>();

	private Date dateCreate;

	public Look() {
	}

	public Look(Integer id, String img, Date dateCreate) {
		this.id = id;
		this.img = img;
		this.dateCreate = dateCreate;
	}

	public Look(Integer id, String img, Set<LookArticles> articles, Date dateCreate) {
		super();
		this.id = id;
		this.img = img;
		this.articles = articles;
		this.dateCreate = dateCreate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<LookArticles> getArticles() {
		return articles;
	}

	public void setArticles(Set<LookArticles> articles) {
		this.articles = articles;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
