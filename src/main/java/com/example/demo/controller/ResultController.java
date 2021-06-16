package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.form.MyNameForm;
import com.example.demo.service.UserService;

@Controller
public class ResultController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(Model model, MyNameForm myNameForm) {
		model.addAttribute("myName", myNameForm.getMyName());
		
		Date dateObj = new Date();
		String dateString = dateObj.toString();
		
		model.addAttribute("date", dateString);
		
		//userテーブルからid=1のデータを取得しコンソールに表示
		User user = userService.getUser("1");
		System.out.println("▲" + user.getId() + ":" + user.getName());
		
		//画面から入力した名前のユーザを作成しにuserテーブルにinsert
		userService.createUser(myNameForm.getMyName());
		
		//userテーブルから全ユーザを取得
		List<User> userList = userService.getAllUser();
		
		//取得した全ユーザをhtmlに渡す
		model.addAttribute("userList", userList);
		
		return "result";
	}
}
