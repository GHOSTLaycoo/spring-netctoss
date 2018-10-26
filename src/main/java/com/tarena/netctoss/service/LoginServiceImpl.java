package com.tarena.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.entity.Admin;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO dao;
	
	public Admin checkLogin(String adminCode, String pwd) {
		Admin admin = null;
		admin = dao.findByAdminCode(adminCode);
		if(admin == null) {
			throw new ApplicationException("�˺Ų�����");
		}
		if(!admin.getPassword().equals(pwd)) {
			throw new ApplicationException("�������");
		}
		return admin;
	}

}
