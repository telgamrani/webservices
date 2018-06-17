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

	public LookArticlesPK(Integer lookId, Integer articleId) {
		this.lookId = lookId;
		this.articleId = articleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((lookId == null) ? 0 : lookId.hashCode());
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
		LookArticlesPK other = (LookArticlesPK) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (lookId == null) {
			if (other.lookId != null)
				return false;
		} else if (!lookId.equals(other.lookId))
			return false;
		return true;
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
