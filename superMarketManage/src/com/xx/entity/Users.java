package com.xx.entity;

public class Users {
	private Integer u_id;//用户ID 
	private Integer userCode;//用户编号
	private String userName;//用户名称
	private String userPassword;//用户密码 
	private Integer userSex;//性别
	private Integer userAge;//年龄
	private Long userTel;//电话
	private String userAddr;//地址
	private Integer userRight;//权限
	
	
	
	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", userCode=" + userCode + ", userName="
				+ userName + ", userPassword=" + userPassword + ", userSex="
				+ userSex + ", userAge=" + userAge + ", userTel=" + userTel
				+ ", userAddr=" + userAddr + ", userRight=" + userRight + "]";
	}
	public Users() {
		super();
	}
	public Users(Integer u_id, Integer userCode, String userName,
			String userPassword, Integer userSex, Integer userAge,
			Long userTel, String userAddr, Integer userRight) {
		super();
		this.u_id = u_id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userTel = userTel;
		this.userAddr = userAddr;
		this.userRight = userRight;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Integer getUserCode() {
		return userCode;
	}
	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Long getUserTel() {
		return userTel;
	}
	public void setUserTel(Long userTel) {
		this.userTel = userTel;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public Integer getUserRight() {
		return userRight;
	}
	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}
	
	
}
