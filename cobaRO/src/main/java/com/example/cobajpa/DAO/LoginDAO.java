package com.example.cobajpa.DAO;

import com.example.cobajpa.model.Login;

public interface LoginDAO {
	public Login getLogin(String username, String password);
}
