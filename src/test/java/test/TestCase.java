package test;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.service.LoginService;

public class TestCase {
	private ApplicationContext ac;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("springmvc.xml");
		
	}
	
	@Test
	public void test1() throws SQLException {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		DataSource ds = ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	@Test
	public void test2() {
		AdminDAO dao = ac.getBean("adminDAO",AdminDAO.class);
		Admin admin = dao.findByAdminCode("caocao");
		System.out.println(admin);
	}
	
	@Test
	public void test3() {
		LoginService service = ac.getBean("loginService",LoginService.class);
		Admin admin = service.checkLogin("caocao", "456");
		System.out.println(admin);
	}
	
	@Test
	public void test4() {
		CostDAO cao = ac.getBean("costDAO",CostDAO.class);
		List<Cost> co = cao.findAll();
		System.out.println(co);
	}
}
