package com.xingxue.www.entity;

public class Category {
	//��Ʒ���
	private Integer id;
	private String name;//�������
	private String code;//�����
	private Integer p_id;//���id
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", code=" + code
				+ ", p_id=" + p_id + "]";
	}
	public Category() {
		super();
	}
	public Category(Integer id, String name, String code, Integer p_id) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.p_id = p_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	
}
