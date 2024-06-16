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

import com.jsp.foodapp.dao.ItemDao;
import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entites.FoodOrder;
import com.jsp.foodapp.entites.Item;
import com.jsp.foodapp.entites.Product;



@Controller
public class itemController {
	@Autowired
	ItemDao dao;
	@Autowired
	ProductDao dao2;
	
	@RequestMapping("/addItems")
	public ModelAndView itemDetails(HttpSession session,@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("itemDetails");
		if(session.getAttribute("itemsList")==null) {
			List<Item> items = new ArrayList<Item>();
			session.setAttribute("itemsList", items);
		}
		Product product = dao2.viewProductById(id);
		Item item = new Item();
		item.setName(product.getName());
		item.setCost(product.getPrice());
		item.setType(product.getType());
		view.addObject("item", item);
		return view;
	}
	@RequestMapping("/additemtofoodorder")
	public ModelAndView addItems(@ModelAttribute("item") Item item, HttpSession session) {
		ModelAndView view = new ModelAndView("redirect:/viewAllProduct");
		item.setCost(item.getCost()*item.getQuentity());
		
		FoodOrder order = (FoodOrder) session.getAttribute("userfoodorder");
		item.setOrder(order);
		
		List<Item> items = (List<Item>) session.getAttribute("itemsList");
		items.add(item);
		return view;
	}

}