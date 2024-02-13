package com.bloodbank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
@Table(name = "blood_bank")
public class Blood_Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blood_bank_id")
	private long blood_bank_id;

	@Column(name = "blood_bank_name")
	private String blood_bank_name;

	@Column(name = "blood_bank_location")
	private String blood_bank_location;

	@Column(name = "available_blood_group")
	private String available_blood_group;

	@Column(name = "blood_quantity")
	private int blood_quantity;


	public long getBlood_bank_id() {
		return blood_bank_id;
	}

	public void setBlood_bank_id(long blood_bank_id) {
		this.blood_bank_id = blood_bank_id;
	}

	public String getBlood_bank_name() {
		return blood_bank_name;
	}

	public void setBlood_bank_name(String blood_bank_name) {
		this.blood_bank_name = blood_bank_name;
	}

	public String getBlood_bank_location() {
		return blood_bank_location;
	}

	public void setBlood_bank_location(String blood_bank_location) {
		this.blood_bank_location = blood_bank_location;
	}

	public String getAvailable_blood_group() {
		return available_blood_group;
	}

	public void setAvailable_blood_group(String available_blood_group) {
		this.available_blood_group = available_blood_group;
	}

	public int getBlood_quantity() {
		return blood_quantity;
	}

	public void setBlood_quantity(int blood_quantity) {
		this.blood_quantity = blood_quantity;
	}


}
