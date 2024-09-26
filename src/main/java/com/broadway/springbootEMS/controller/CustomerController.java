package com.broadway.springbootEMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.contants.CartStatus;
import com.broadway.springbootEMS.model.Cart;
import com.broadway.springbootEMS.model.Product;
import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.repository.CartRepository;
import com.broadway.springbootEMS.repository.ProductRepository;
import com.broadway.springbootEMS.service.CartService;
import com.broadway.springbootEMS.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class CustomerController {
	@Autowired
	CartService cs;
	@Autowired
	CartRepository cr;
	@Autowired
	private ProductService ps;

	@Autowired
	private ProductRepository pr;



	@PostMapping("/search")
	private String getSearch(Model model,@RequestParam String search) {

		List<Product> sList=pr.findAll(search);
	

		model.addAttribute("sList",sList);
		return "Search";
	}




	@GetMapping({"/cHome","/"})
	private String getCustomer(Model model , HttpSession session) {
		model.addAttribute("pList", ps.getAll());
		User u = (User) session.getAttribute("validuser");
		session.setAttribute("cList", cr.findByUserAndStatus(u, CartStatus.ACTIVE));



		List<Cart> c = cr.findByUserAndStatus(u, CartStatus.ACTIVE);
		session.setAttribute("size", c.size());  

		//calculate total
		double total=0;
		for(Cart cart : c) {
			total=total+(cart.getSubTotal());
		}
		System.out.println(total);
		session.setAttribute("total",total);


		model.addAttribute("eList", ps.pListByCategory("electronics"));
		model.addAttribute("jList" , ps.pListByCategory("jewelery"));
		List<Object> mwList= new ArrayList<>();
		mwList.addAll(ps.pListByCategory("men's clothing"));
		mwList.addAll(ps.pListByCategory("women's clothing"));
		model.addAttribute("mwList",mwList);
		System.out.println(mwList);

		return "Customer_Home";
	}

	@GetMapping("/category")
	private String getCategory(Model model, HttpSession session) {
		model.addAttribute("pList", ps.getAll());
		//		User u = (User) session.getAttribute("validuser");
		//		List<Cart> c = cs.getByUser(u);
		//		model.addAttribute("cList", cs.getByUser(u));
		//		model.addAttribute("size", c.size());
		return "category";
	}
	@GetMapping("/jewellery")
	private String getJewellery( Model model, HttpSession session) {
		model.addAttribute("jList" , ps.pListByCategory("jewelery"));
		//		User u = (User) session.getAttribute("validuser");
		//		List<Cart> c = cs.getByUser(u);
		//		model.addAttribute("cList", cs.getByUser(u));
		//		model.addAttribute("size", c.size());
		return "Jewellery";
	}
	@GetMapping("/electronics")
	private String getElectronics( Model model, HttpSession session) {
		model.addAttribute("eList", ps.pListByCategory("electronics"));
		//		User u = (User) session.getAttribute("validuser");
		//		List<Cart> c = cs.getByUser(u);
		//		model.addAttribute("cList", cs.getByUser(u));
		//		model.addAttribute("size", c.size());
		return "Electronics";
	}
	@GetMapping("/men")
	private String getMen( Model model, HttpSession session) {
		model.addAttribute("mList", ps.pListByCategory("men's clothing"));
		//		User u = (User) session.getAttribute("validuser");
		//		List<Cart> c = cs.getByUser(u);
		//		model.addAttribute("cList", cs.getByUser(u));
		//		model.addAttribute("size", c.size());
		return "Men";
	}
	@GetMapping("/women")
	private String getWomen( Model model, HttpSession session) {
		model.addAttribute("wList", ps.pListByCategory("women's clothing"));
		//		User u = (User) session.getAttribute("validuser");
		//		List<Cart> c = cs.getByUser(u);
		//		model.addAttribute("cList", cs.getByUser(u));
		//		model.addAttribute("size", c.size());
		return "Women";
	}
	@GetMapping("/checkout")
	private String getCheckout(Model model, HttpSession session) {
		//	User u = (User) session.getAttribute("validuser");
		//	List<Cart> c = cs.getByUser(u);
		//	model.addAttribute("cList", cs.getByUser(u));
		//	model.addAttribute("size", c.size());

		return"Checkout";
	}



}
