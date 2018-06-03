package com.htw.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.htw.dao.utils.ArticleType;

@Entity
public class Look implements Serializable {

	private static final long serialVersionUID = -8710052231804094981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// @Column(nullable = false)
	private String img;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private Set<LookArticles> lookArticles = new HashSet<LookArticles>();

	private Date dateCreate;

	public Look() {
	}

	public Look(Integer id, String img, Set<LookArticles> lookArticles, Date dateCreate) {
		super();
		this.id = id;
		this.img = img;
		this.lookArticles = lookArticles;
		this.dateCreate = dateCreate;
	}

	public Look(String img, Set<LookArticles> lookArticles, Date dateCreate) {
		super();
		this.img = img;
		this.lookArticles = lookArticles;
		this.dateCreate = dateCreate;
	}

	public Look(String img, Date dateCreate) {
		super();
		this.img = img;
		this.lookArticles = lookArticles;
		this.dateCreate = dateCreate;
	}

	public void addArticle(Article article, ArticleType articleType, Integer position) {
		LookArticles lookArticle = new LookArticles();
		lookArticle.setLook(this);
		lookArticle.setArticle(article);
		lookArticle.setArticleType(articleType);
		lookArticle.setPosition(position);
		if (article.getLooksArticle() == null)
			article.setLooksArticle(new HashSet<>());
		article.getLooksArticle().add(lookArticle);
		this.lookArticles.add(lookArticle);
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

	public Set<LookArticles> getLookArticles() {
		return lookArticles;
	}

	public void setLookArticles(Set<LookArticles> lookArticles) {
		this.lookArticles = lookArticles;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
