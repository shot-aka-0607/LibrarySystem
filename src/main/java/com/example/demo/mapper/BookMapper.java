package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;

@Mapper
public interface BookMapper {
	// 主キー検索
	User findOne(String id);
	
	//全件検索
	List<Book> findAll();
	
	//登録
	void create(Book book);
}
