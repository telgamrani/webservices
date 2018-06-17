package com.htw.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.htw.dao.model.json.ArticleJson;
import com.htw.dao.model.json.LookJson;
import com.htw.dao.utils.ArticleType;

@Entity
public class Look implements Serializable {

	private static final long serialVersionUID = -8710052231804094981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// @Column(nullable = false)
	private String imgUrl;

	@OneToMany(mappedBy = "look", cascade = CascadeType.ALL)
	@Where(clause = "article_type like 'PRINCIPAL'")
	private List<LookArticles> principalArticles = new ArrayList<LookArticles>();

	@OneToMany(mappedBy = "look", cascade = CascadeType.ALL)
	@Where(clause = "article_type like 'SECONDARY'")
	private List<LookArticles> moreArticles = new ArrayList<LookArticles>();

	private Date dateCreate;

	public Look() {
	}

	public Look(String imgUrl, Date dateCreate) {
		this.imgUrl = imgUrl;
		this.dateCreate = dateCreate;
	}

	public LookJson convertToJson() {
		LookJson lookJson = new LookJson();
		lookJson.setId(this.getId());
		lookJson.setImgUrl(this.getImgUrl());
		this.principalArticles.forEach(a -> {
			ArticleJson articleJson = a.getArticle().convertToJson();
			articleJson.setPosition(a.getPosition());
			articleJson.setArticleType(a.getArticleType());
			lookJson.getPrincipalArticles().add(articleJson);

		});
		this.moreArticles.forEach(a -> {
			ArticleJson articleJson = a.getArticle().convertToJson();
			articleJson.setPosition(a.getPosition());
			articleJson.setArticleType(a.getArticleType());
			lookJson.getMoreArticles().add(articleJson);

		});

		return lookJson;
	}

	public void addArticle(Article article, ArticleType articleType, Integer position) {
		LookArticles lookArticle = new LookArticles(this, article);
		lookArticle.setArticleType(articleType);
		lookArticle.setPosition(position);
		if(ArticleType.PRINCIPAL.equals(articleType)) {
			principalArticles.add(lookArticle);
		}else {
			moreArticles.add(lookArticle);
		}
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
		Look other = (Look) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public List<LookArticles> getPrincipalArticles() {
		return principalArticles;
	}

	public void setPrincipalArticles(List<LookArticles> principalArticles) {
		this.principalArticles = principalArticles;
	}

	public List<LookArticles> getMoreArticles() {
		return moreArticles;
	}

	public void setMoreArticles(List<LookArticles> moreArticles) {
		this.moreArticles = moreArticles;
	}
}
