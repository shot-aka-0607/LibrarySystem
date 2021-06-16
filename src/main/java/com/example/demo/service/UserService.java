package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	/* 
	 * 引数で指定したidのユーザをDBから取得
	 * @param id
	 * @return 取得したユーザ
	 */
	public User getUser(String id) {
		User user = userMapper.findOne(id);
		return user;
	}
	
	/*
	 * 全ユーザをDBから取得
	 * @return 取得した全ユーザ
	 */
	public List<User> getAllUser(){
		List<User> userList = userMapper.findAll();
		return userList;
	}
	
	/*
	 * 引数で指定された名前のユーザを作成し、DBにINSERT
	 * @param name
	 */
	public void createUser(String name) {
		User user = new User();
		user.setName(name);
		userMapper.create(user);
	}
}
