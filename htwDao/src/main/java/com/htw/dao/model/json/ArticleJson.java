package com.htw.dao.model.json;

import com.htw.dao.model.Article;
import com.htw.dao.utils.ArticleType;

public class ArticleJson {

	private Integer id;
	private String imgUrl;
	private Double price;
	private String shoppingUrl;
	private String currency = "€";
	private ArticleType articleType;
	private Integer position;

	public ArticleJson() {
	}

	public Article convertToDao() {
		Article article = new Article();
		article.setId(this.getId());
		article.setImgUrl(this.getImgUrl());
		article.setPrice(Double.valueOf(this.getPrice()));
		article.setShoppingUrl(this.getShoppingUrl());
		return article;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public ArticleType getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}



}
