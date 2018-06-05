package com.example.cobajpa.controller.tes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.cobajpa.service.admin.KaryawanService;



@RestController
public class TesRestController {
	@Autowired
	KaryawanService aks;
//	
//	@RequestMapping("karyawanres")
//	public List<Login> tesaja() {
//		
//		return aks.getAllLogin();
//		
//	}
}
