package com.tarena.netctoss.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Cost;


@Repository("costDAO")
public class CostDAOjdbcImpl implements CostDAO{
	
	@Resource(name="ds")
	private DataSource ds;

	public List<Cost> findAll() {
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from cost_lhh "+"order by id";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = new Cost();
				c.setCostId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				list.add(c);
			}
			return list;
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
	}
	
	public static void main(String[] args) {
		CostDAO dao = new CostDAOjdbcImpl();
		List<Cost> list = dao.findAll();
		for(Cost c:list) {
			System.out.println(c.getCostId()+","+c.getName());
		}
	}
	
}
