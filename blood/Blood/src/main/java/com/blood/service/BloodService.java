package com.blood.service;

import java.util.List;

import com.blood.entity.Blood;



public interface BloodService {
	void save(Blood blood);
	Blood getById(Integer id);
	List<Blood> getAll();
}
