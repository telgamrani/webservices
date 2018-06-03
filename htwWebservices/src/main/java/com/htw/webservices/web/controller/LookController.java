package com.htw.webservices.web.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.htw.webservices.model.Look;

@RestController
public class LookController {

	static List<Look> looks;
	static Look look;

	static {
		looks = Arrays.asList(new Look(1, "img 1", new Date()), new Look(2, "img 2", new Date()),
				new Look(3, "img 3", new Date()));
		look = new Look(1, "img 1", new Date());
	}

	@GetMapping(value = "/looks/{currentPage}/{numPerPage}")
	public List<Look> getLooks(@PathVariable int currentPage, @PathVariable int numPerPage) {
		System.out.println("/looks/{" + currentPage + "}/{" + numPerPage + "}");
		return looks;
	}

	@GetMapping(value = "/looks/{id}")
	public Look getLookById(@PathVariable int id) {
		System.out.println("/looks/{" + id + "}");
		return look;
	}

}
