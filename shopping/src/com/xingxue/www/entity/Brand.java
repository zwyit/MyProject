package com.xingxue.www.entity;

public class Brand {
	//Ʒ�Ʊ�
	private Integer id;
	private String name;//Ʒ������
	private String code;//Ʒ�Ʊ��
	private String remark;//Ʒ�Ʊ�ע
	
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", code=" + code
				+ ", remark=" + remark + "]";
	}
	public Brand() {
		super();
	}
	public Brand(Integer id, String name, String code, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.remark = remark;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
