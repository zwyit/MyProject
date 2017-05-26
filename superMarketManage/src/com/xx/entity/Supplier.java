package com.xx.entity;

public class Supplier {
	private Integer s_id;
	private Integer supplierCode;
	private String supplierName;
	private String supplierDexc;
	private String supplierPerson;
	private Long supplierTel;
	private String supplierChuan;
	private String supplierAddr;
	
	
	
	
	@Override
	public String toString() {
		return "Supplier [s_id=" + s_id + ", supplierCode=" + supplierCode
				+ ", supplierName=" + supplierName + ", supplierDexc="
				+ supplierDexc + ", supplierPerson=" + supplierPerson
				+ ", supplierTel=" + supplierTel + ", supplierChuan="
				+ supplierChuan + ", supplierAddr=" + supplierAddr + "]";
	}
	public Supplier() {
		super();
	}
	public Supplier(Integer s_id, Integer supplierCode, String supplierName,
			String supplierDexc, String supplierPerson, Long supplierTel,
			String supplierChuan, String supplierAddr) {
		super();
		this.s_id = s_id;
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.supplierDexc = supplierDexc;
		this.supplierPerson = supplierPerson;
		this.supplierTel = supplierTel;
		this.supplierChuan = supplierChuan;
		this.supplierAddr = supplierAddr;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Integer getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(Integer supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierDexc() {
		return supplierDexc;
	}
	public void setSupplierDexc(String supplierDexc) {
		this.supplierDexc = supplierDexc;
	}
	public String getSupplierPerson() {
		return supplierPerson;
	}
	public void setSupplierPerson(String supplierPerson) {
		this.supplierPerson = supplierPerson;
	}
	public Long getSupplierTel() {
		return supplierTel;
	}
	public void setSupplierTel(Long supplierTel) {
		this.supplierTel = supplierTel;
	}
	public String getSupplierChuan() {
		return supplierChuan;
	}
	public void setSupplierChuan(String supplierChuan) {
		this.supplierChuan = supplierChuan;
	}
	public String getSupplierAddr() {
		return supplierAddr;
	}
	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}
	
	
}
