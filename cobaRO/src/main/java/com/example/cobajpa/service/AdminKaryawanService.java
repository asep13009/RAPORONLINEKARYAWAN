package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cobajpa.DAO.AdminKaryawanDAO;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.AdminDataKaryawanRepository;
import com.example.cobajpa.repository.AdminKaryawanRepository;

@Service
public class AdminKaryawanService implements AdminKaryawanDAO {
	@Autowired
	AdminKaryawanRepository adminKaryawanRepository;
	@Autowired
	AdminDataKaryawanRepository adminDataKaryawanRepository;
	
	@Override
	public List<Login> getAllLogin(){
		List<Login> logins = new ArrayList<>();
		adminKaryawanRepository.findAll().forEach(logins::add);;
		return logins;
	}
	@Override
	public Login getById(long id) {
		Login login=adminKaryawanRepository.findById(id).get();
		return login;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void SaveOrUpdate(Login login,Karyawan karyawan) {
		
		try {
			karyawan= adminDataKaryawanRepository.save(karyawan);
			login.setKaryawan(karyawan);
			adminKaryawanRepository.save(login);
		} catch (Exception e) {
			System.out.println("err " +e);
		}
		
	}
	@Override
	public void deleteIDLogin(long id) {
		adminKaryawanRepository.deleteById(id);
	}
	@Override
	public void deleteLogin(Login login) {
		adminKaryawanRepository.delete(login);
	}	
	

}
