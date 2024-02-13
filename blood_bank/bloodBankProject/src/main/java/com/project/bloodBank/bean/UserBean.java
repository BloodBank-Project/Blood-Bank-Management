package com.project.bloodBank.bean;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserBean implements Serializable{
	
	private Long user_id;

	private String first_name;

	private String last_name;

	private String email;

	private String password;

	private Date date_of_birth;

	private String gender;

	private String address;

	private Long contact_number;

	private Long alternate_contact_number;

	private String type;

	private Long blood_group_id;
	
	private Long blood_bank_id;

}
