package com.patient.bean;

import java.sql.Date;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientRequestBean {
	
	private Long patient_request_id;
	private Long patient_request_units;
	private Date patient_request_on_date;
	private String patient_medical_condition;
	private String status;
}
