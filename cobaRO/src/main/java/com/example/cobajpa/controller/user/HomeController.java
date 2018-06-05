package com.example.cobajpa.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;




@Controller
@SessionAttributes("penggunaaktif")
public class HomeController {
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	@RequestMapping(value="home.html")
	public String goHome() {
		return "user/home";
	}
	
	@RequestMapping(value="rapor.html")
	public String goRapor() {
		return "user/rapor";
	}
	
	@RequestMapping(value="kemajuan.html")
	public String goKemajuan() {
		return "user/kemajuan";
	}
	

	@RequestMapping(value="catatan.html")
	public String goCatatan() {
		return "user/catatan";
	}
	
		
	
	
}
