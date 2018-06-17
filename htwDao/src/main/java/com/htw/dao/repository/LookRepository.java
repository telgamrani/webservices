package com.htw.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.htw.dao.model.Look;

public interface LookRepository extends JpaRepository<Look, Integer> {

	@Query("SELECT l FROM Look l where l.id = :id")
	Optional<Look> findLookById(@Param("id") Integer id);
}
