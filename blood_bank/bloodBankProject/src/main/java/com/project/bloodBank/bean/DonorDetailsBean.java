package com.project.bloodBank.bean;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DonorDetailsBean implements Serializable{
	
	private Long donationId;
	
	private Long bloodQuantity;
	
	private Date dateOfDonation;
	
	private String status;
	
}
 