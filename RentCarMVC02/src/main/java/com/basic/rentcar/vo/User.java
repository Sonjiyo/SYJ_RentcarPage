package com.basic.rentcar.vo;

public class User {
	private int no;
	private String id;
	private String pw;
	private String email;
	private String tel;
	private String hobby;
	private String job;
	private int age;
	private String info;
	
	
	
	public int getNo() {
		return no;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}
	public String getHobby() {
		return hobby;
	}
	public String getJob() {
		return job;
	}
	public int getAge() {
		return age;
	}
	public String getInfo() {
		return info;
	}
	public User(int no, String id, String pw, String email, String tel, String hobby, String job, int age, String info) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
	}
	
	
}
