package com.xwj.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xwj.entity.UserEntity;
import com.xwj.mapper.UserMapper;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Cacheable
	public List<UserEntity> findAll() {
		return userMapper.findAll();
	}

	@Cacheable(value = "user", key = "'id_'+#id")
	public UserEntity findById(String id) {
		return userMapper.findById(id, "xwj");
	}

	// 清空缓存，allEntries变量表示所有对象的缓存都清除
	@CacheEvict(value = { "findAll", "findById" }, allEntries = false)
	public void insertUser(String id, String name, Integer age) {
		userMapper.addUser(id, name, age);
	}

	@CacheEvict(value = { "findAll", "findById" }, allEntries = true)
	public void updateUser(String id, String name) {
		userMapper.updateUser(id, name);
	}

	@CacheEvict(value = { "findAll", "findById" }, allEntries = true)
	public void deleteUser(String id) {
		userMapper.deleteUser(id);
	}

	@Async
	public void sendSms() {
		System.out.println("####sendSms####   2");
		IntStream.range(0, 5).forEach(d -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("####sendSms####   3");
	}

}
