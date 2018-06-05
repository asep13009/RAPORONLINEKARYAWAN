package com.example.cobajpa.controller.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.cobajpa.model.Login;

public class LogoutController {
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/logout.html", produces = "text/plain")

	public String logout() throws ServletException {
		
	  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	  request.logout();
		 return "index";
	}
}
