package com.example.cobajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.LoginService;


@Controller
@SessionAttributes("penggunaaktif")
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value="login.html")
	public String getLogin(@ModelAttribute("Login") Login login,ModelMap mav) {
		String view;
		Login penggunaaktif = loginService.getLogin(login.getUsername(), login.getPassword());
		if(penggunaaktif==null) {
			view = "index";
		}else {
			view ="user/home";
		}

		mav.addAttribute("penggunaaktif", penggunaaktif);
		return view;		
	}
}
