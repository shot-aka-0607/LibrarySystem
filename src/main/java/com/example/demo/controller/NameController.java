package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.MyNameForm;

@Controller
public class NameController {
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String name(Model model) {
		MyNameForm myNameForm = new MyNameForm();
		model.addAttribute("myNameForm", myNameForm);
		
		return "name";
	}

}
