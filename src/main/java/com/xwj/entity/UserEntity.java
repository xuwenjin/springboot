package com.xwj.entity;

import java.io.Serializable;

/**
 * 要想使用redis存对象，一定要让实体类实现Serializable接口，否则会报错。
 * 
 * @author xuwenjin
 */
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 9075408797495215871L;

	private String id;
	
	private String lastName;
	
	private String email;
	
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
	
}
