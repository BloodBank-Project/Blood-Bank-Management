package com.project.bloodBank.service;

import java.util.List;

import com.project.bloodBank.bean.DonorDetailsBean;

public interface DonorDetailsService {
	
	void save(DonorDetailsBean donorBean);
	
	DonorDetailsBean getByDonorId(Long id);
	
	void update(DonorDetailsBean donorBean) ;
	
	void delete(Long id);
	
	 List<DonorDetailsBean> getAllDonors();

}
