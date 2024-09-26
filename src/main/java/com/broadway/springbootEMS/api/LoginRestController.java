package com.broadway.springbootEMS.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.contants.Role;
import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.service.UserService;
import com.broadway.springbootEMS.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;

public class LoginRestController {

	@Autowired   
	private UserService userService;  
	
	@PostMapping("/login")
	private String postUser(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String gCode) throws IOException {
				if (VerifyRecaptcha.verify(gCode)) {
					user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
					User u = userService.loginUser(user.getUsername(), user.getPassword());
					if (u != null) {
						session.setAttribute("validuser", u);
						session.setMaxInactiveInterval(10*60);						
						if(u.getRole().equals(Role.ADMIN)) {
							return "Home";
						}
						else {
							return "redirect:/";
						}
					} else {
						model.addAttribute("loginMessage", "Username or password doesnot match");
						return "LoginForm";
					}
				}
				model.addAttribute("loginMessage", "you are a robot");		
				return "LoginForm";
	}
	


}
