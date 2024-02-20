package com.project.bloodBank.bean;

import java.sql.Date;

public interface DonorInfoBean {
	
	Long getId();
	
	Long getUser_id();
	
	String getFirst_name();

	String getLast_name();

	String getEmai();

	String getPassword();

	Date getDate_of_birth();

	String getGender();

	String getAddress();

	Long getContact_number();

	Long getAlternate_contact_number();

	String getType();

	Long getBlood_group_id();
	
	Long getBlood_bank_id();
	

}
