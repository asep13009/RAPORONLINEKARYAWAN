package com.example.cobajpa.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cobajpa.model.Login;

@Repository
public interface AdminKaryawanRepository extends CrudRepository<Login, Long> {
//	List<Login> findByName(String name);
//	List<Login> findPersonDistinctByName(String name);
//	List<Login> findPersonOrderByNameDesc();
	Login findByUsernameAndPassword(String username, String password);
}


