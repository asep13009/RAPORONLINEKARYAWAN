package com.example.cobajpa.controller;

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
	@RequestMapping(value="biodata.html")
	public String goBiodata() {
		return "user/biodata";
	}
	@RequestMapping(value="gantipass.html")
	public String goGantiPass() {
		return "user/gantipass";
	}
	@RequestMapping(value="catatan.html")
	public String goCatatan() {
		return "user/catatan";
	}
	
	@RequestMapping(value="logout.html")
	public String goLogout() {
		return "redirect:/index";
	}
	
	
}
