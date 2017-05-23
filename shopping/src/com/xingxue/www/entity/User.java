package com.xingxue.www.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer id;
	private String user_name;
	private String user_password;
	private String user_email;
	private Date user_joined;
	private Integer user_points;
	private Integer user_right;
	private String user_remark;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_email="
				+ user_email + ", user_joined=" + user_joined
				+ ", user_points=" + user_points + ", user_right=" + user_right
				+ ", user_remark=" + user_remark + "]";
	}
	public User() {
		super();
	}
	public User(Integer id, String user_name, String user_password,
			String user_email, Date user_joined, Integer user_points,
			Integer user_right, String user_remark) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_joined = user_joined;
		this.user_points = user_points;
		this.user_right = user_right;
		this.user_remark = user_remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getUser_joined() {
		return user_joined;
	}
	public void setUser_joined(Date user_joined) {
		this.user_joined = user_joined;
	}
	public Integer getUser_points() {
		return user_points;
	}
	public void setUser_points(Integer user_points) {
		this.user_points = user_points;
	}
	public Integer getUser_right() {
		return user_right;
	}
	public void setUser_right(Integer user_right) {
		this.user_right = user_right;
	}
	public String getUser_remark() {
		return user_remark;
	}
	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	
	
}
