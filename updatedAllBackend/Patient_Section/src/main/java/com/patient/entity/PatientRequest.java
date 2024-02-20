package com.patient.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patient_request_id;
	private Long patient_request_units;
	private Date patient_request_on_date;
	private String patient_medical_condition;
	private String status;

}