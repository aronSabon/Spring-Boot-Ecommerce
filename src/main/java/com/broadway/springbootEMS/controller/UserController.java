package com.broadway.springbootEMS.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.contants.Role;
import com.broadway.springbootEMS.model.Cart;
import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.service.CartService;
import com.broadway.springbootEMS.service.UserService;
import com.broadway.springbootEMS.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

@Log
@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	CartService cs;

	//	
	//	@GetMapping("/" )
	//	private String customerHome() {
	//		return "Customer_Home";
	//	}

	@GetMapping("/home")
	private String getHome() {
		return "Home";
	}

	@GetMapping("/login" )
	private String getUser() {
		return "LoginForm";
	}

	@PostMapping("/login")
	private String postUser(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String gCode) throws IOException {
				if (VerifyRecaptcha.verify(gCode)) {
					user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
					User u = us.loginUser(user.getUsername(), user.getPassword());
					if (u != null) {
						log.info(" user login success");
						session.setAttribute("validuser", u);
						session.setMaxInactiveInterval(10*60);						
						if(u.getRole().equals("ADMIN")) {
							return "Home";
						}
						else {
							return "redirect:/";
						}
					} else {
						model.addAttribute("loginMessage", "Username or password doesnot match");
						log.info(" user login failed");
		
						return "LoginForm";
					}
				}
				model.addAttribute("loginMessage", "you are a robot");
				log.info(" user login failed");
		
				return "LoginForm";
			


                               //without recaptcha verifiction
//		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
//		User u = us.loginUser(user.getUsername(), user.getPassword());
//		if (u != null) {
//			
//			log.info(" user login success");
//			session.setAttribute("validuser", u);
//			//				session.setAttribute("cList", cs.getByUser(u));
//			//				List<Cart> c = cs.getByUser(u);
//			//				session.setAttribute("size", c.size());   
//			//session.setMaxInactiveInterval(2000);
//			session.setMaxInactiveInterval(10*60);
//
//			// model.addAttribute("username",user.getUsername());
//
//			if(u.getRole().equals(Role.ADMIN)) {
//				return "Home";
//			}
//		
//			else {
//				return "redirect:/";
//			}
//		} else {
//			model.addAttribute("loginMessage", "Username or password doesnot match");
//			log.info(" user login failed");
//
//			return "LoginForm";
//		}
	}

	@GetMapping("/signUp" )
	private String getUssignuper() {
		return "SignUpForm";
	}
	@GetMapping("/signUpAdmin" )
	private String getUssign() {
		return "SignUpAdmin";
	}
	@PostMapping("/signUp")
	private String postSignUp(@ModelAttribute User user, Model model) {
		User u = us.doesUserExist(user.getUsername());
		if (u != null) {
			model.addAttribute("signUpMessage", "username already exists");
			return "SignUpForm";
		} else {
			model.addAttribute("username", user.getUsername());
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			user.setRole(Role.CUSTOMER);
			us.addUser(user);
			return "LoginForm";
		}
	}
	@PostMapping("/signUpAdmin")
	private String postAdminSignUp(@ModelAttribute User user, Model model) {
		User u = us.doesUserExist(user.getUsername());
		if (u != null) {
			model.addAttribute("signUpMessage", "username already exists");
			return "SignUpForm";
		} else {
			model.addAttribute("username", user.getUsername());
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			user.setRole(Role.ADMIN);
			us.addUser(user);
			return "LoginForm";
		}
	}

	@GetMapping("/logout")
	private String logout(HttpSession session) {

		session.invalidate();
		return "LoginForm";
	}

	@GetMapping("/profile")
	public String getProfile() {
		return "Profile";
	}

}
