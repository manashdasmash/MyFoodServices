package com.jsp.foodapp.controller;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.entites.Admin;



@Controller
public class AdminController {

	@Autowired
	AdminDao dao;

	@RequestMapping("/addAdmin")
	public ModelAndView AddAdmin() {
		ModelAndView view = new ModelAndView("Createadmin");
		Admin admin = new Admin();
		view.addObject("admin", admin);
		return view;
	}

	@RequestMapping("/verifyAdmin")
	public ModelAndView verifyAdmin() {
		ModelAndView view = new ModelAndView("AdminLogin");
		return view;
	}

	@RequestMapping("/saveAdmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin admin, HttpSession session) {
		ModelAndView view = new ModelAndView("AdminPanel");
		dao.saveAdmin(admin);
		session.setAttribute("admin", admin);
		return view;

	}

	@RequestMapping("/AdminLogin")
	public ModelAndView ioginAdmin(ServletRequest req, HttpSession session) {

		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		

		Admin admin = dao.login(name, pwd);
		if (admin == null) {
			ModelAndView view = new ModelAndView("AdminLogin");
			view.addObject("message",
					"<p style='color:red; text-align:center'> Sorry, your password was incorrect. Please double-check your password..<p>");
			return view;
		} else {
			ModelAndView view = new ModelAndView("AdminPanel");
			view.addObject("message", "<h3 style='color:red; text-align:center'> LogIn Sucessfull....<h3>");
			session.setAttribute("admin", admin);
			return view;

		}

	}
	@RequestMapping("/adminLogout")
	public ModelAndView adminLogout(HttpSession session) {
		ModelAndView view = new ModelAndView("index");
		session.invalidate();
		view.addObject("message", "<h3 style='color:red; text-align:center'> Logout Sucessfull....<h3>");
		return view;
	}

}