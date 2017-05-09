package com.hrd.bookstore.models.dto;

public class StudentDto {

	private String roleNo;
	private String name;
	private String gender;
	public StudentDto() {	}
	public StudentDto(String roleNo, String name, String gender) {
		super();
		this.roleNo = roleNo;
		this.name = name;
		this.gender = gender;
	}
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
