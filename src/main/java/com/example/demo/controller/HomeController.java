package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//MyNameForm myNameForm = new MyNameForm();
		//model.addAttribute("myNameForm", myNameForm);
		
		return "home";
	}

}
