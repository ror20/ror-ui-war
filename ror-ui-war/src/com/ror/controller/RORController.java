package com.ror.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RORController {

	@RequestMapping("/main")
	public ModelAndView sampleControllerCheck(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("index", "status", "Controller hit Success!!");
	}

}
