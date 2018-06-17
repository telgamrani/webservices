package com.htw.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.htw.dao.utils.ArticleType;

@Entity
public class LookArticles implements Serializable {

	private static final long serialVersionUID = -5579131590220724587L;

	@EmbeddedId
	private LookArticlesPK id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("lookId")
	private Look look;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("articleId")
	private Article article;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ArticleType articleType;

	@Column(nullable = false)
	private Integer position;

	public LookArticles() {
	}

	public LookArticles(Look look, Article article) {
		this.look = look;
		this.article = article;
		this.id = new LookArticlesPK(look.getId(), article.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((look == null) ? 0 : look.hashCode());
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
		LookArticles other = (LookArticles) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (look == null) {
			if (other.look != null)
				return false;
		} else if (!look.equals(other.look))
			return false;
		return true;
	}

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
