package com.htw.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.htw.dao.model.json.ArticleJson;

@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 7731559122619927665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String imgUrl;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private String shoppingUrl;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<LookArticles> looks = new ArrayList<LookArticles>();

	public Article() {
	}

	public Article(String imgUrl, Double price, String shoppingUrl) {
		this.imgUrl = imgUrl;
		this.price = price;
		this.shoppingUrl = shoppingUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ArticleJson convertToJson() {
		ArticleJson articleJson = new ArticleJson();
		articleJson.setId(this.getId());
		articleJson.setImgUrl(this.getImgUrl());
		articleJson.setPrice(this.getPrice());
		articleJson.setShoppingUrl(this.getShoppingUrl());
		return articleJson;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<LookArticles> getLooks() {
		return looks;
	}

	public void setLooks(List<LookArticles> looks) {
		this.looks = looks;
	}


}
