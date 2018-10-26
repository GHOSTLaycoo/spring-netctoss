package com.tarena.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Admin;

@Repository("adminDAO")
public class AdminDAOjdbcImpl implements AdminDAO{
	
	@Resource(name="ds")
	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) {
		Admin admin = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info_lhh "+"where admin_code=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return admin;
	}
	
}
