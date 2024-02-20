package com.patient.bean;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserBean {

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

	private BloodBean blood_group_id;

	private BloodBankBean blood_bank_id;

}
