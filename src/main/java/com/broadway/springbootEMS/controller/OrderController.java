package com.broadway.springbootEMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.model.DeliveryAddress;
import com.broadway.springbootEMS.model.Product;
import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.service.CartService;
import com.broadway.springbootEMS.service.DeliveryAddressService;
import com.broadway.springbootEMS.service.ProductService;
import com.broadway.springbootEMS.service.UserService;

@Controller
public class OrderController {
	@Autowired
	ProductService ps;
	@Autowired
	CartService cs;
	@Autowired
	UserService us;
	@Autowired
	DeliveryAddressService das;
	@GetMapping("/order")
	private String getOrder(Model model) {
		List<DeliveryAddress> aList= das.getAllAddress();
		model.addAttribute("aList",aList);
		return "Order";
	}
//	                                    ,@RequestParam int dId
	
	@GetMapping("/orderDetails")                   
	private String getOrderDetails(Model model,@RequestParam int dId) {
		
		
		
//		
////		User u = us.getUserById(id);
////		model.addAttribute("cList", cs.getByUser(u));
//		
//		                      //for products
//		DeliveryAddress da = das.getAddressById(dId);
//		System.out.println(das.getAddressById(dId));
//		System.out.println(das.getAddressById(dId));
//		System.out.println(das.getAddressById(dId));
//		System.out.println(das.getAddressById(dId));
//		System.out.println(das.getAddressById(dId));
//		System.out.println(das.getAddressById(dId));
//		System.out.println(da.getProductsIdList());
//		System.out.println(da.getProductsIdList());
//		System.out.println(da.getProductsIdList());
//		System.out.println(da.getProductsIdList());
//		List<String> pId= da.getProductsIdList();
//		List<Product> pList = new ArrayList<>();
//		for(String s : pId) {
//			pList.add(ps.getById(Integer.parseInt(s)));	
//		}
//		model.addAttribute("pList", pList);
		
		                  //for delivery details
		model.addAttribute("deliveryAddress", das.getAddressById(dId));
		System.out.println(das.getAddressById(dId));
		//model.addAttribute("delvList",das.getAllAddress());

		return "OrderDetails";
	}
}
