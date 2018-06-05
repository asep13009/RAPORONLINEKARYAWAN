package com.example.cobajpa.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.admin.KaryawanService;
import com.example.cobajpa.service.user.LoginService;


@Controller
@SessionAttributes("penggunaaktif")
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	KaryawanService karyawanService;
	@RequestMapping(value="login.html")
	public ModelAndView getLogin(@ModelAttribute("Login") Login login,@ModelAttribute("karyawan") Karyawan karyawan) {
		ModelAndView mav = new ModelAndView();
		
		Login penggunaaktif = loginService.getLogin(login.getUsername(), login.getPassword());
		if(penggunaaktif==null) {
			mav.setViewName("index");
		}else if (penggunaaktif.getKaryawan().getJabatan().getId()==1) {
			mav.setViewName("atasan/home");
		}else if (penggunaaktif.getKaryawan().getJabatan().getId()==2){
			mav.setViewName("user/home");
		}else if (penggunaaktif.getKaryawan().getJabatan().getId()==3) {
			mav.addObject("listkaryawan",karyawanService.getAllKaryawan());
			mav.setViewName("admin/karyawan");
		}

		mav.addObject("penggunaaktif", penggunaaktif);
		return mav;		
	}


}