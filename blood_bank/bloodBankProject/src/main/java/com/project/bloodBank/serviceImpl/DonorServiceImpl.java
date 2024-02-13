//package com.project.bloodBank.serviceImpl;
//
//import java.util.ArrayList;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.project.bloodBank.bean.DonorBean;
//import com.project.bloodBank.bean.UserBean;
//import com.project.bloodBank.entity.DonorEntity;
//import com.project.bloodBank.exceptions.DonorNotFoundException;
//import com.project.bloodBank.repository.DonorRepository;
//import com.project.bloodBank.service.DonorService;
//
//@Service
//public class DonorServiceImpl implements DonorService {
//	@Autowired
//	private DonorRepository donorRepository;
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Override
//	public void save(DonorBean donorBean) {
//
//		DonorEntity donorEntity = new DonorEntity();
//		beanToEntity(donorEntity, donorBean);
//		System.out.println("data is going to save"+donorBean);
//		try {
//		donorRepository.save(donorEntity);
//		}
//		catch(DonorNotFoundException e) {
//			throw e;
//		}
//	}
//
//	@Override
//	public DonorBean getByDonorId(Long id) {
//		DonorBean donorBean = new DonorBean();
////		DonorEntity donorEntity;
//		try {
//			DonorEntity donorEntity = donorRepository.findById(id)
//					.orElseThrow(() -> new DonorNotFoundException("donor is not found to delete with this " + id));
//			entityToBean(donorEntity, donorBean);
//		} catch (DonorNotFoundException e) {
//			throw e;
//		}
//		return donorBean;
//	}
//
//	@Override
//	public void update(DonorBean donorBean) {
//		Optional<DonorEntity> donorEntity = donorRepository.findById(donorBean.getId());
//		if (donorEntity.isPresent()) {
//			DonorEntity donorEntity2 = donorEntity.get();
//			donorEntity2.setId(donorBean.getId());
//			donorEntity2.setUserId(donorBean.getUserId().getUser_id());
//			donorRepository.save(donorEntity2);
//		} else {
//			try {
//				throw new DonorNotFoundException("Donor is not available to update with this " + donorBean.getId());
//			} catch (DonorNotFoundException e) {
//				throw e;
//			}
//		}
//	}
//
//	@Override
//	public void delete(Long id) {
////		donorRepository.deleteById(id);
//
//		Optional<DonorEntity> findById = donorRepository.findById(id);
//		if (findById.isEmpty()) {
//			try {
//				findById.orElseThrow(() -> new DonorNotFoundException("donar id is  not found to delete"));
//			} catch (DonorNotFoundException e) {
//				throw e;
//			}
//		} else {
//			donorRepository.deleteById(id);
//		}
//	}
//
//	@Override
//	public List<DonorBean> getAllDonors() {
//		List<DonorEntity> entities = donorRepository.findAll();
//		List<DonorBean> beans = new ArrayList<>();
//		entityToBeanList(entities, beans);
//		return beans;
//	}
//
//	public void entityToBean(DonorEntity donorEntity, DonorBean donorBean) {
//		donorBean.setId(donorEntity.getId());
//		donorBean.setUserId(donorEntity.getUserId());
////		donorBean.setUserId(getByDonorId(donorEntity.getUserId()));
//		donorBean.setDonarDetails(donorEntity.getDonarDetails());
//	}
//
//	public void beanToEntity(DonorEntity donorEntity, DonorBean donorBean) {
////		donorEntity.setId(donorBean.getId());
//		donorEntity.setUserId(donorBean.getUserId().getUser_id());
//		donorEntity.setDonarDetails(donorBean.getDonarDetails());
//	}
//
//	public void entityToBeanList(List<DonorEntity> donorEntity, List<DonorBean> donorBean) {
//
//		for (DonorEntity donorEntity2 : donorEntity) {
//
//			DonorBean bean = new DonorBean();
//			bean.setId(donorEntity2.getId());
//			bean.setUserId(donorEntity2.getUserId());
//			bean.setDonarDetails(donorEntity2.getDonarDetails());
//			donorBean.add(bean);
//		}
//	}
//
//	@Override
//	public DonorBean getById(Long id) {
//		
//		Optional<DonorEntity> optional = donorRepository.findById(id);
//		if (optional.isEmpty()) {
//			try {
//				optional.orElseThrow(() -> new DonorNotFoundException("Donor Id Is Not Found"));
//			} catch (DonorNotFoundException e) {
//				throw e;
//			}
//		}
//		DonorEntity donorEntity = optional.get();
//		String Userurl = "http://localhost:8020/bloodBank/user/" + id;
//		HttpHeaders headers = new HttpHeaders();
//
//		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		ResponseEntity<UserBean> reponseEntity = restTemplate.exchange(Userurl, HttpMethod.GET, httpEntity,
//				UserBean.class);
//		UserBean userBean = reponseEntity.getBody();
//		DonorBean donorBean = DonorBean.builder().id(donorEntity.getId()).userId(userBean.getUser_id()).build();
//		return donorBean;
//	}
//
////	public UserBean getUserId(Long id) {
////		UserBean userBean = new UserBean();
//////		DonorEntity donorEntity;
////		try {
////			DonorEntity donorEntity = donorRepository.findById(id)
////					.orElseThrow(() -> new DonorNotFoundException("User is not found to g with this " + id));
////			entityToUserBean(donorEntity, userBean);
////		} catch (DonorNotFoundException e) {
////			throw e;
////		}
////		return userBean;
////		
//	}
//
////	----------------------------using Entity----------------------------------------
////	@Override
////	public DonorEntity save(DonorEntity donorEntity) {
////		 return donorRepository.save(donorEntity);
////	}
////
////	@Override
//////	public Optional<DonorEntity> getById(Long id) {
////	public DonorEntity getById(Long id) {
////
//////		return donorRepository.findById(id);
////
////		Optional<DonorEntity> findById = donorRepository.findById(id);
////		if (findById.isEmpty()) {
////			try {
////				findById.orElseThrow(() -> new DonorNotFoundException(id + "donar id is not found to get"));
////			} catch (DonorNotFoundException e) {
////				throw e;
////			}
////		}
////		return findById.get();
////	}
////
////	@Override
////	public Optional<DonorEntity> update(DonorEntity donorEntity) {
////		Optional<DonorEntity> findById = donorRepository.findById(donorEntity.getId());
////		if (findById.isPresent()) {
////			donorRepository.save(donorEntity);
////			return findById;
////		}
//////		else {
//////			System.out.println("Enter the correct id");
//////		}
//////		return null;
////		return Optional.of(findById.orElseThrow(() -> new DonorNotFoundException("donar id is not found to update")));
////
////	}
////
////	@Override
////	public List<DonorEntity> getAll() {
////		return donorRepository.findAll();
////	}
////	
////	@Override
////	public void delete(Long id) {
//////		donorRepository.deleteById(id);
////
////		Optional<DonorEntity> findById = donorRepository.findById(id);
////		if (findById.isEmpty()) {
////			try {
////				findById.orElseThrow(() -> new DonorNotFoundException("donar id is  not found to delete"));
////			} catch (DonorNotFoundException e) {
////				throw e;
////			}
////		} else {
////			donorRepository.deleteById(id);
////		}
////	}
////	
//}
