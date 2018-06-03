package com.htw.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LookArticlesPK implements Serializable {

	private static final long serialVersionUID = -6148998762306223214L;

	@Column(name = "look_id")
	private Integer lookId;

	@Column(name = "article_id")
	private Integer articleId;

	public LookArticlesPK() {
	}

	public Integer getLookId() {
		return lookId;
	}

	public void setLookId(Integer lookId) {
		this.lookId = lookId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

}
