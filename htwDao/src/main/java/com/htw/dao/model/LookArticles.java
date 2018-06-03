package com.htw.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.htw.dao.utils.ArticleType;

@Entity
public class LookArticles implements Serializable {

	private static final long serialVersionUID = -5579131590220724587L;

	@EmbeddedId
	private LookArticlesPK id;

	@ManyToOne
	@MapsId("lookId")
	@JoinColumn(name = "look_id")
	private Look look;

	@ManyToOne
	@MapsId("articleId")
	@JoinColumn(name = "article_id")
	private Article article;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ArticleType articleType;

	@Column(nullable = false)
	private Integer position;

	public LookArticlesPK getId() {
		return id;
	}

	public void setId(LookArticlesPK id) {
		this.id = id;
	}

	public Look getLook() {
		return look;
	}

	public void setLook(Look look) {
		this.look = look;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
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
