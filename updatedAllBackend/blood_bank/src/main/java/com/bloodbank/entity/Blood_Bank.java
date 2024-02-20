package com.bloodbank.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="blood_bank")
public class Blood_Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="blood_bank_id")
	private long blood_bank_id;
	
	@Column(name="blood_bank_name")
	private String blood_bank_name;
	
	@Column(name="blood_bank_location")
	private String blood_bank_location;
	
	@Column(name="available_blood_group")
	private String available_blood_group;
	
	@Column(name="blood_quantity")
	private int blood_quantity;
	
}
