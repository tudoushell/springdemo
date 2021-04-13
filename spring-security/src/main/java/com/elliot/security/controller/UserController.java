package com.elliot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: elliot
 * @Date: 2021/4/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping("")
	public String get() {
		return "hello security";
	}
}
