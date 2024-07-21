package com.broadway.springbootEMS.service;

import java.util.List;

import com.broadway.springbootEMS.contants.CartStatus;
import com.broadway.springbootEMS.model.Cart;
import com.broadway.springbootEMS.model.User;

public interface CartService {
void addCart(Cart cart);
List<Cart> getAllCart();
void deleteById(int id);
List<Cart> getByUser(User user);
//List<Cart> getByUserAndStatus(User user,CartStatus status);	
Cart getById(int id);
}
