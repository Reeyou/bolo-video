package com.reeyou.boloweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Reeyou
 * @data 2019/6/26 11:57
 */
@RestController
public class helloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
