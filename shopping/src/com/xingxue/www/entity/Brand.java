package com.xingxue.www.entity;

public class Brand {
	//品牌表
	private Integer id;
	private String name;//品牌名称
	private String code;//品牌编号
	private String remark;//品牌备注
	
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
