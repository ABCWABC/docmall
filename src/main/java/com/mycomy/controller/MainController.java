package com.mycomy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/category/*")
@Controller
@AllArgsConstructor
public class MainController {
	
	@GetMapping("/main")
	public void index() {
		log.info("main...");
	}
	@GetMapping("/404")
	public void fzf() {
		log.info("404..."); // 404 에러페이지
	}
	@GetMapping("/blank")
	public void blank() {
		log.info("blank..."); // 빈페이지
	}
	@GetMapping("/best")
	public void best() {
		log.info("best..."); //  best 카테고리 페이지
	}
}
