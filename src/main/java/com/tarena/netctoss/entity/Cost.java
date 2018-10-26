package com.tarena.netctoss.entity;

import java.io.Serializable;

public class Cost implements Serializable {
	private Integer costId;
	private String name;
	private String password;
	
	
	@Override
	public String toString() {
		return "Cost [costId=" + costId + ", name=" + name + ", password=" + password + "]";
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
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

}
