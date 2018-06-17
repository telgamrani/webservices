package com.htw.dao.model.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.htw.dao.model.Look;

public class LookJson {

	private Integer id;
	private String imgUrl;
	private List<ArticleJson> principalArticles = new ArrayList<ArticleJson>();
	private List<ArticleJson> moreArticles = new ArrayList<ArticleJson>();

	public LookJson() {
	}

	public Look convertToDao() {
		Look look = new Look();
		look.setId(this.getId());
		look.setImgUrl(this.getImgUrl());
		look.setDateCreate(new Date());
		this.principalArticles.forEach(a -> {
			look.addArticle(a.convertToDao(), a.getArticleType(), a.getPosition());
		});
		this.moreArticles.forEach(a -> {
			look.addArticle(a.convertToDao(), a.getArticleType(), a.getPosition());
		});
		return look;
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

	public List<ArticleJson> getPrincipalArticles() {
		return principalArticles;
	}

	public void setPrincipalArticles(List<ArticleJson> principalArticles) {
		this.principalArticles = principalArticles;
	}

	public List<ArticleJson> getMoreArticles() {
		return moreArticles;
	}

	public void setMoreArticles(List<ArticleJson> moreArticles) {
		this.moreArticles = moreArticles;
	}
}
