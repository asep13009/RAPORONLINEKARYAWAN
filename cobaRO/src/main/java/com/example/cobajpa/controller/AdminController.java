package com.example.cobajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.model.Person;
import com.example.cobajpa.service.AdminKaryawanService;

@Controller
@SessionAttributes("penggunaaktif")
public class AdminController {
	@Autowired
	private AdminKaryawanService adminKaryawanService;
	
	@RequestMapping(value="karyawan.html",method=RequestMethod.POST)
	public ModelAndView goPerson(@ModelAttribute("login")Login login,@ModelAttribute("karyawan")Karyawan karyawan) {
//		adminKaryawanService.SaveOrUpdate(login, karyawan);
		return new ModelAndView("admin/karyawan","listlogin",adminKaryawanService.getAllLogin());
	}
	@RequestMapping(value="karyawan.html",method=RequestMethod.GET)
	public ModelAndView goPersonafterUpdate(@ModelAttribute("login")Login login , @ModelAttribute("karyawan") Karyawan karyawan) {
		return new ModelAndView("admin/karyawan","listlogin",adminKaryawanService.getAllLogin());
	}

	@RequestMapping(value="pengguna.html")
	public String adminPengguna() {
		return "admin/pengguna";
	}
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
	
//	=================================
	@RequestMapping(value="insertkaryawan.html",method=RequestMethod.POST)
	public String insertUpdateKaryawan(@ModelAttribute("login") Login login,@ModelAttribute("karyawan") Karyawan karyawan) {
		adminKaryawanService.SaveOrUpdate(login, karyawan);
		return "redirect:karyawan.html";
	}
	
	
	
}
