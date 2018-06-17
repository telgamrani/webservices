package com.htw.webservices.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.htw.dao.model.Article;
import com.htw.dao.model.Look;
import com.htw.dao.model.json.LookJson;
import com.htw.dao.repository.LookRepository;
import com.htw.dao.utils.ArticleType;

@RestController
public class LookController {

	@Autowired
	LookRepository lookRepository;

	@PostConstruct
	public void init() {
		Look _look = new Look("img", new Date());
		for (int i = 0; i < 5; i++) {
			Article article = new Article("img", 25.99, "shoppingUrl");
			_look.addArticle(article, ArticleType.PRINCIPAL, 1);
		}
		lookRepository.save(_look);
	}

	@GetMapping(value = "/looks/{currentPage}/{numPerPage}")
	public List<LookJson> getLooks(@PathVariable int currentPage, @PathVariable int numPerPage) {
		System.out.println("/looks/{" + currentPage + "}/{" + numPerPage + "}");

		List<Look> looks = lookRepository.findAll();
		List<LookJson> looksJson = new ArrayList<LookJson>();
		looks.forEach(l -> {
			looksJson.add(l.convertToJson());
		});
		return looksJson;
	}

	@GetMapping(value = "/looks/{id}")
	public LookJson getLookById(@PathVariable int id) {
		System.out.println("/looks/{" + id + "}");

		Look look = lookRepository.findLookById(id).orElse(null);
		LookJson lookJson = null;
		if(look != null){
			lookJson = look.convertToJson();
		}
		
		return lookJson;
	}

}
