package com.patient.bean;

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
public class PatientBean {

	private Long patient_id;
	private UserBean user_details;
	private List<PatientRequestBean> patientRequestDetails;
}
