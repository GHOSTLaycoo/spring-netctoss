package com.tarena.netctoss.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private Integer adminId;
	private String adminCode;
	private String password;
	private String name;
	private String telephone;
	private String email;
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminCode=" + adminCode + ", password=" + password + ", name=" + name
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
}
