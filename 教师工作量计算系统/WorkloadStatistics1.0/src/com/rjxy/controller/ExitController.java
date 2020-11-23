package com.rjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Exit")
public class ExitController {
	@RequestMapping("/A")
	public String exitController() {
		return "Login";
	}
}
