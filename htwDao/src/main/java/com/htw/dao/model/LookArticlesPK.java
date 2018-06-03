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

}
