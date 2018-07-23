package com.xwj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xwj.entity.UserEntity;
import com.xwj.service.UserService;

@RestController
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<UserEntity> findAll(){
		return userService.findAll();	
	}
	
	@RequestMapping("/find")
	public UserEntity findById(String id){
		return userService.findById(id);	
	}
	
	@RequestMapping("/insert")
	public void insertUser(String id, String name){
		userService.insertUser(id, name, 30);
	}
	
	@RequestMapping("/udpate")
	public void updateUser(String id, String name){
		userService.updateUser(id, name);
	}
	
	@RequestMapping("/delete")
	public void deleteUser(String id){
		userService.deleteUser(id);
	}
	
	@RequestMapping("/async")
	public String async(){
		System.out.println("####IndexController####   1");
		userService.sendSms();
		System.out.println("####IndexController####   4");
		return "success";
	}
	
}
