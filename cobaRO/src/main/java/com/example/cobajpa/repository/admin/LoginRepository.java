package com.example.cobajpa.repository.admin;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cobajpa.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
//	List<Login> findByName(String name);
//	List<Login> findPersonDistinctByName(String name);
//	List<Login> findPersonOrderByNameDesc();
	Login findByUsernameAndPassword(String username, String password);
}


