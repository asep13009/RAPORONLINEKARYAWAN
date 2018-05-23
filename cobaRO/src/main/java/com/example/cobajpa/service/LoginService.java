package com.example.cobajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.LoginDAO;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.AdminKaryawanRepository;

@Service
public class LoginService implements LoginDAO {
	@Autowired
	AdminKaryawanRepository akr;
	
	 @Override
	public Login getLogin(String username, String password) {
		return akr.findByUsernameAndPassword(username, password);
	}
	
	
}
