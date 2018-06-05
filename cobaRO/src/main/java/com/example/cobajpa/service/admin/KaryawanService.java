package com.example.cobajpa.service.admin;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.KaryawanDAO;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.admin.DataKaryawanRepository;
import com.example.cobajpa.repository.admin.LoginRepository;




@Service
public class KaryawanService implements KaryawanDAO {
	
	@Autowired
	DataKaryawanRepository dataKaryawanRepository;
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public List<Karyawan> getAllKaryawan() {
		List<Karyawan> karyawans = new ArrayList<>();
		dataKaryawanRepository.findAll().forEach(karyawans::add);;
		return karyawans;
	}
	@Override
	public Karyawan getByIdKaryawan(long id) {
		Karyawan karyawan=dataKaryawanRepository.findById(id).get();
		return karyawan;
	}
	@Override
	public void SaveOrUpdateKaryawan(Karyawan karyawan, Login login) {
		dataKaryawanRepository.save(karyawan);
		login.setKaryawan(karyawan);
		loginRepository.save(login);
	}
	@Override
	public void SaveOrUpdateKaryawan1(Karyawan karyawan) {
		dataKaryawanRepository.save(karyawan);
	}
	@Override
	public void deleteIDKaryawan(long id) {
		dataKaryawanRepository.deleteById(id);
		
	}
	@Override
	public void deleteKaryawan(Karyawan karyawan) {
		dataKaryawanRepository.delete(karyawan);
		
	}
	
	
}
