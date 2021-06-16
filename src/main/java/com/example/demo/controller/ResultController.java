package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Book;
import com.example.demo.form.BookInfoForm;
import com.example.demo.service.BookService;

@Controller
public class ResultController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(Model model, BookInfoForm bookInfoForm) {
		//画面から入力した名前と値段の本を作成しbookテーブルにinsert
		bookService.createBook(bookInfoForm.getName(), bookInfoForm.getPrice());
		
		//登録した書籍名を追加
		model.addAttribute("registBookName", bookInfoForm.getName());
		
		//bookテーブルから全ての書籍を取得
		List<Book> bookList = bookService.getAllBook();
		
		//取得したリストをhtmlに渡す
		model.addAttribute("bookList", bookList);
		
		return "result";
	}
}
