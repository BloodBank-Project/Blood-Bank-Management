package com.blood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blood_group")
public class Blood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blood_id")
	private Integer blood_id;

	@Column(name = "blood_type")
	private String blood_type;

	public Integer getBlood_id() {
		return blood_id;
	}

	public void setBlood_id(Integer blood_id) {
		this.blood_id = blood_id;
	}

	public String getBlood_type() {
		return blood_type;
	}

	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}

	@Override
	public String toString() {
		return "Blood [blood_id=" + blood_id + ", blood_type=" + blood_type + "]";
	}

}
