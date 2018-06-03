package com.htw.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 7731559122619927665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String img;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private String shoppingUrl;

	@OneToMany(mappedBy = "look")
	private Set<LookArticles> looksArticle = new HashSet<LookArticles>();

	public Article() {
	}

	public Article(Integer id, String img, Double price, String shoppingUrl, Set<LookArticles> looksArticle) {
		super();
		this.id = id;
		this.img = img;
		this.price = price;
		this.shoppingUrl = shoppingUrl;
		this.looksArticle = looksArticle;
	}

	public Article(String img, Double price, String shoppingUrl, Set<LookArticles> looks) {
		super();
		this.img = img;
		this.price = price;
		this.shoppingUrl = shoppingUrl;
		this.looksArticle = looks;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getShoppingUrl() {
		return shoppingUrl;
	}

	public void setShoppingUrl(String shoppingUrl) {
		this.shoppingUrl = shoppingUrl;
	}

	public Set<LookArticles> getLooksArticle() {
		return looksArticle;
	}

	public void setLooksArticle(Set<LookArticles> looksArticle) {
		this.looksArticle = looksArticle;
	}

}
