package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;

public interface AdminKaryawanDAO {
	public List<Login> getAllLogin();
	public Login getById(long id);
	public void SaveOrUpdate(Login login,Karyawan karyawan);
	public void deleteIDLogin(long id);
	public void deleteLogin(Login login);
}
