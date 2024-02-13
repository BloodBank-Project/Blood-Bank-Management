package com.project.bloodBank.entity;

import java.io.Serializable;
import java.util.List;

import com.project.bloodBank.bean.UserBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DonorEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	@OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
	@JoinColumn(name = "donor_id", referencedColumnName = "id")
	private List<DonorDetailsEntity> donarDetails;
}