package com.broadway.springbootEMS.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadway.springbootEMS.contants.CartStatus;
import com.broadway.springbootEMS.model.Cart;
import com.broadway.springbootEMS.model.DeliveryAddress;
import com.broadway.springbootEMS.model.Product;
import com.broadway.springbootEMS.model.ShippingAddress;
import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.repository.CartRepository;
import com.broadway.springbootEMS.service.DeliveryAddressService;
import com.broadway.springbootEMS.service.ShippingAddressService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeliveryController {
	@Autowired
	private CartRepository cr;
	@Autowired
	DeliveryAddressService das;
	@Autowired
	ShippingAddressService sas;
	@PostMapping("/placeOrder")
	private String getPlaceOrder(@ModelAttribute DeliveryAddress deliveryAddress,HttpSession session) {
		User u = (User) session.getAttribute("validuser");
		deliveryAddress.setUser(u);
		deliveryAddress.setDate(Calendar.getInstance().getTime());
		
		List<Cart> cart= cr.findByUserAndStatus(u, CartStatus.ACTIVE);

		
		
		                  // calculate total for admin page
			double total=0;
	        for(Cart cartt : cart) {
	        	total=total+(cartt.getSubTotal());
	        }
		deliveryAddress.setTotal(total); 
		
		                   // for product  list
		List<Product> productlist= new ArrayList<>();
		
		for(Cart c:cart) {
			 productlist.add(c.getProduct());
		}	
		deliveryAddress.setProductsIdList(productlist);
//		                   for quantity List
		List<Integer> quantityList=new ArrayList<>();
		for(Cart c:cart) {
			 quantityList.add(c.getQuantity());
		}
		deliveryAddress.setQuantity(quantityList);
		
		
		das.addBillingAddress(deliveryAddress);
		cr.updateCartStatusByUserId(u.getId(),CartStatus.INACTIVE);
		
return "redirect:/";
	}

}
