package com.example.cobajpa.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.cobajpa.model.Login;

@RestController
@SessionAttributes("penggunaaktif")
public class TesController {

	@RequestMapping("/tessss")
	public Login getAktif(@ModelAttribute("penggunaaktif") Login l) {
		return l;
	}
}
