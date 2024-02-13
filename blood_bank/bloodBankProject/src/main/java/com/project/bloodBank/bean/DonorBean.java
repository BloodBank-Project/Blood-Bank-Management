
package com.project.bloodBank.bean;

import java.io.Serializable;
import java.util.List;

import com.project.bloodBank.entity.DonorDetailsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorBean implements Serializable {

	private Long id;

	private UserBean userId;

	private List<DonorDetailsEntity> donarDetails;
}
