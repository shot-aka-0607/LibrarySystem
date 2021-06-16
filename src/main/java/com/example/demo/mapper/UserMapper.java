package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	// 主キー検索
	User findOne(String id);
	
	//全件検索
	List<User> findAll();
	
	//登録
	void create(User user);
}
