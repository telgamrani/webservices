package com.htw.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htw.dao.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
