package com.htw.webservices.web.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.htw.dao.model.Article;
import com.htw.dao.model.Look;
import com.htw.dao.model.LookArticles;
import com.htw.dao.repository.ArticleRepository;
import com.htw.dao.repository.LookRepository;
import com.htw.dao.utils.ArticleType;

@RestController
public class LookController {

	@Autowired
	LookRepository lookRepository;

	@Autowired
	ArticleRepository articleRepository;

	static Set<Look> looks = new HashSet<Look>();
	static Set<LookArticles> lookArticlesSet = new HashSet<LookArticles>();

	static {
		looks.addAll(Arrays.asList(new Look(1, "img 1", null, new Date()), new Look(2, "img 2", null, new Date()),
				new Look(3, "img 3", null, new Date())));
	}

	@GetMapping(value = "/looks/{currentPage}/{numPerPage}")
	public List<Look> getLooks(@PathVariable int currentPage, @PathVariable int numPerPage) {
		System.out.println("/looks/{" + currentPage + "}/{" + numPerPage + "}");

		List<Look> _looks = lookRepository.findAll();
		for (Look look : _looks) {
			look.getLookArticles().iterator().next().setLook(null);
			look.getLookArticles().iterator().next().getArticle().setLooksArticle(null);
		}
		return _looks;
	}

	@GetMapping(value = "/looks/{id}")
	public Optional<Look> getLookById(@PathVariable int id) {
		System.out.println("/looks/{" + id + "}");

		Look _look = new Look("img", new Date());
		Article article = new Article("img", 10.0, "shoppingUrl", null);
		_look.addArticle(article, ArticleType.PRINCIPAL, 1);
		lookRepository.save(_look);


		Optional<Look> look = lookRepository.findById(id);
		look.get().getLookArticles().iterator().next().setLook(null);
		look.get().getLookArticles().iterator().next().getArticle().setLooksArticle(null);
		return look;
	}

}
