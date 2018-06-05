package com.example.cobajpa.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.LoginDAO;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.admin.LoginRepository;

@Service
public class LoginService implements LoginDAO {
	@Autowired
	LoginRepository akr;
	
	 @Override
	public Login getLogin(String username, String password) {
		return akr.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Login> getAllLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getByIdLogin(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveOrUpdateLogin(Login login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteIDLogin(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKaryawan(Login login) {
		// TODO Auto-generated method stub
		
	}
}
