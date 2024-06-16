package com.jsp.foodapp.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entites.Product;



@Controller
public class ProductController {
	@Autowired
	ProductDao dao;

	@RequestMapping("/addProduct")
	public ModelAndView addProduct() {
		ModelAndView view = new ModelAndView("AddProduct");
		Product product = new Product();
		view.addObject("product", product);
		return view;
	}

	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		ModelAndView view = new ModelAndView("AdminPanel");
		dao.saveProduct(product);
		view.addObject("saveProductMessage", "<h3 style='color:red; text-align:center'> Product Saved Sucessfully<h3>");
		return view;
	}
	@RequestMapping("/productUpdate")
	public ModelAndView productUpdate(@ModelAttribute("product") Product product) {
		ModelAndView view = new ModelAndView("AdminPanel");
		dao.updateProduct(product);
		view.addObject("saveProductMessage", "<h3 style='color:red; text-align:center'> Product Update Sucessfully<h3>");
		return view;
	}
// Whenever we want to forward request from one endpoint to another end-point
// then we have to use "redirect:/'end-point name'" in ModelAndView.
	@RequestMapping("/allProduct")
	public ModelAndView allProduct() {
		ModelAndView view = new ModelAndView("AllProduct");
		List<Product> products = dao.viewAllProduct();
		view.addObject("products", products);
		return view; 
	}
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("UpdateProduct");
		Product product = dao.viewProductById(id);
		view.addObject("product", product);
		return view;
		
	}
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("redirect:/allProduct");
		dao.deleteProdctById(id);
		view.addObject("deleteProductMessage", "<h3 style='color:red; text-align:center'> Product Delete Sucessfully<h3>");
		return view;
		
	}
	
	@RequestMapping("/viewAllProduct")
	public ModelAndView viewAllProduct() {
		ModelAndView view = new ModelAndView("viewProducts");
		List<Product> products = dao.viewAllProduct();
		view.addObject("products",products);
		return view;
	}
	
	/*@RequestMapping("/viewProductById")
	public ModelAndView viewProductById(@RequestParam("id") int id) {
	    ModelAndView view = new ModelAndView("ViewProduct"); // Assuming you have a view named ViewProduct.jsp or ViewProduct.html
	    Product product = dao.viewProductById(id);
	    view.addObject("product", product);
	    return view;
	}*/

	

}
