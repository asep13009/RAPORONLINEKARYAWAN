package com.example.cobajpa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {
	
	@RequestMapping(value="konten.html")
	public String adminKonten() {
		return "admin/konten";
	}
	@RequestMapping(value="aspek.html")
	public String adminAspek() {
		return "admin/aspek";
	}
	@RequestMapping(value="subaspek.html")
	public String adminSubAspek() {
		return "admin/subaspek";
	}
	@RequestMapping(value="perdepartemen.html")
	public String adminPerdepartemen() {
		return "admin/perdepartemen";
	}
	@RequestMapping(value="raport.html")
	public String adminRaport() {
		return "admin/raport";
	}
}
