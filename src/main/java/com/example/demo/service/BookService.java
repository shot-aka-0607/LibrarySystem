package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	/*
	 * 全ユーザをDBから取得
	 * @return 取得した全ユーザ
	 */
	public List<Book> getAllBook(){
		List<Book> bookList = bookMapper.findAll();
		return bookList;
	}
	
	/*
	 * 引数で指定された本を作成し、DBにINSERT
	 * @param name
	 */
	public void createBook(String name, int price) {
		Book book = new Book();
		book.setName(name);
		book.setPrice(price);
		bookMapper.create(book);
	}
}
