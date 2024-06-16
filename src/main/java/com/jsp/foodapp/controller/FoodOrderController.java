package com.jsp.foodapp.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrderDao;
import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entites.FoodOrder;
import com.jsp.foodapp.entites.Item;
import com.jsp.foodapp.entites.User;




@Controller
public class FoodOrderController {

	double totalBill = 0;
	@Autowired
	FoodOrderDao dao;
	@Autowired
	UserDao dao2;
	
	@RequestMapping("/foodorder")
	public ModelAndView createFoodOredr() {
		ModelAndView view = new ModelAndView("Createfoodorder");
		FoodOrder order = new FoodOrder();
		view.addObject("foodorder", order);
		return view;
	}
	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder foodOrder, HttpSession session)
	{
		ModelAndView view = new ModelAndView("redirect:/viewAllProduct");
		session.setAttribute("userfoodorder", foodOrder);
		return view;
		
	}
	@RequestMapping("/submitfoodorder")
	public ModelAndView submitFoodOrder(HttpSession session) {
		FoodOrder foodOrder = (FoodOrder) session.getAttribute("userfoodorder");
		List<Item> items = (List<Item>) session.getAttribute("itemsList");
		foodOrder.setItems(items);
		items.stream().forEach(i-> {
			totalBill = totalBill + i.getCost();
		});
		foodOrder.setTotalBill(totalBill);
		User user = (User) session.getAttribute("user");
		List<FoodOrder> orders = user.getOrders();
		if(orders.size()>0) {
			orders.add(foodOrder);
			foodOrder.setUser(user);
			user.setOrders(orders);
		}
		else {
			List<FoodOrder> orders2 = new ArrayList<FoodOrder>();
			orders2.add(foodOrder);
			foodOrder.setUser(user);
			user.setOrders(orders2);
		}
		session.setAttribute("user", user);
		
		totalBill = 0;
		ModelAndView view = new ModelAndView("ConfirmOrder");
		view.addObject("foodOrder", foodOrder);
		session.setAttribute("foodOrder", foodOrder);
		return view;
	}
	
	@RequestMapping("/finalSubmit")
	public ModelAndView finalSubmit(HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		FoodOrder foodOrder = (FoodOrder) session.getAttribute("foodOrder");
		dao.saveFoodOrder(foodOrder);
		dao2.updateUser(user);
		List<Item> items = (List<Item>) session.getAttribute("itemsList");
		items.removeAll(items);
		session.setAttribute("itemsList", items);
		session.removeAttribute("foodOrder");
		ModelAndView view = new ModelAndView("UserPanel");
		view.addObject("message", "<h3 style='color:red; text-align:center'>Order Placed Sucessfully<h3>");
		return view;		
	}
	
	@RequestMapping("/viewPreviousOrder")
	public ModelAndView showPreviousFoodOrders(HttpSession session) {
		User user =(User) session.getAttribute("user");
		List<FoodOrder> foodOrders = user.getOrders();
		ModelAndView view = new ModelAndView("AllFoodOrders");
		view.addObject("allFoodOrders", foodOrders);
		return view;
	}
	
	@RequestMapping("/viewAllFoodOrders")
	public ModelAndView viewAllFoodOrders() {
		ModelAndView view = new ModelAndView("AllFoodOrders");
		view.addObject("allFoodOrders", dao.viewAllFoodOrder());
		return view;
	}
	
	@RequestMapping("/showItems")
	public ModelAndView showItems(@RequestParam("id") int id) {
		FoodOrder foodOrder = dao.viewFoodOrderById(id);
		ModelAndView view = new ModelAndView("ViewItems");
		view.addObject("showItems", foodOrder);
		return view;
		
	}
}
