package com.neusoft.entity;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private int power;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		if(this.getPower() == 1){
			return this.getId()+"   "+ this.getUsername()+"   "+this.getEmail()+"   管理员";
		}else{
			return this.getId()+"   "+ this.getUsername()+"   "+this.getEmail()+"   普通用户";
		}
	}
	
}
