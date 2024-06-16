package com.jsp.foodapp.controller;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entites.User;



@Controller
public class UserController {

	@Autowired
	UserDao dao;

	@RequestMapping("/addUser")
	public ModelAndView AddUser() {
		ModelAndView view = new ModelAndView("CreateUser");
		User user = new User();
		view.addObject("user", user);
		return view;
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		ModelAndView view = new ModelAndView("UserLogin");
		dao.saveUser(user);
		return view;

	}

	@RequestMapping("/UserLogin")
	public ModelAndView loginUser(ServletRequest req, HttpSession session) {

		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		User user = dao.login(name, pwd);
		if(user==null) {
			ModelAndView view = new ModelAndView("UserLogin");
			view.addObject("message",
					"<p style='color:red; text-align:center'> Sorry, your password was incorrect. Please double-check your password..<p>");
			return view;
		} else {
			ModelAndView view = new ModelAndView("UserPanel");
			session.setAttribute("user", user);
			view.addObject("message", "<h3 style='color:red; text-align:center'> LogIn Sucessfull....<h3>");
			return view;

		
		}
	}
	@RequestMapping("/userLogout")
	public ModelAndView userLogout(HttpSession session) {
	ModelAndView view = new ModelAndView("index");
	session.invalidate();
	view.addObject("message", "<h3 style='color:red; text-align:center'> Logout Sucessfull....<h3>");
	return view;
	}
}
