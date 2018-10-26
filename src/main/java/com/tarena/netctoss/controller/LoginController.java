package com.tarena.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.service.ApplicationException;
import com.tarena.netctoss.service.CostService;
import com.tarena.netctoss.service.LoginService;
import com.tarena.netctoss.util.ImageUtil;



@Controller
public class LoginController {
	@Resource(name = "loginService")
	private LoginService service; 
	
	@Resource(name = "costService")
	private CostService see;
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session) {
		System.out.println("login()");
		//获取账户，密码，图片
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("password");
		String code = request.getParameter("code");
		
		//保存账号值在服务器
		session.setAttribute("adminCode", adminCode);
		System.out.println(adminCode+" "+pwd);
		
		String imgcode = (String) session.getAttribute("imgcode");
		
			if(code==null||!code.equalsIgnoreCase(imgcode)) {
				request.setAttribute("error", "验证码错误");
				return "login";
			}
			Admin admin = service.checkLogin(adminCode, pwd);
			session.setAttribute("admin", admin);
		
		return "redirect:toIndex.do";
	}
	
	@ExceptionHandler
	public String exHandle(Exception ex,HttpServletRequest request) {
		System.out.println("exHandle()");
		if(ex instanceof ApplicationException) {
			request.setAttribute("login_failed", ex.getMessage());
			return "login";
		}
		return "error";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("/findCost.do")
	public String findCost(HttpServletRequest request) {
		System.out.println("findCost()");
		try {
			List<Cost> list = see.findCost();
			request.setAttribute("costs", list);
		} catch (Exception e) {
			System.out.println("hhhh");
		}
		return "find";
	}
	
	
	
	
	@RequestMapping("/createImg.do")
	protected void createImg(
			HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
			Object[] objs = ImageUtil.createImage();
			HttpSession session = req.getSession();
			session.setAttribute("imgcode", objs[0]);
			res.setContentType("image/png");
			OutputStream os = res.getOutputStream();
			BufferedImage img = (BufferedImage) objs[1];
			ImageIO.write(img, "png", os);
			os.close();
	}
	
}
