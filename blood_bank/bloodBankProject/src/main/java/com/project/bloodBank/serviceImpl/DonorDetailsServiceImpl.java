package com.project.bloodBank.serviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bloodBank.bean.DonorDetailsBean;
import com.project.bloodBank.entity.DonorDetailsEntity;

@Service
public class DonorDetailsServiceImpl /* implements DonorDetailsService */ {

//	@Autowired
//	private DonorDetailsRepository detailsRepository;
//
//	@Override
//	public void save(DonorDetailsBean donorBean) {
//
//		DonorDetailsEntity donorEntity = new DonorDetailsEntity();
//		beanToEntity(donorEntity, donorBean);
//		detailsRepository.save(donorEntity);
//	}
//
//	@Override
//	public DonorDetailsBean getByDonorId(Long id) {
//		DonorDetailsBean donorBean = new DonorDetailsBean();
////		DonorEntity donorEntity;
//		try {
//			DonorDetailsEntity donorEntity = detailsRepository.findById(id).orElseThrow(
//					() -> new DonationDetailsNotFoundException("details are not found to delete with this " + id));
//			entityToBean(donorEntity, donorBean);
//		} catch (DonationDetailsNotFoundException e) {
//			throw e;
//		}
//		return donorBean;
//	}
//
//	@Override
//	public void update(DonorDetailsBean donorBean) {
//		Optional<DonorDetailsEntity> donorEntity = detailsRepository.findById(donorBean.getDonationId());
//		if (donorEntity.isPresent()) {
//			DonorDetailsEntity donorEntity2 = donorEntity.get();
//			donorEntity2.setDonationId(donorBean.getDonationId());
//			donorEntity2.setStatus(donorBean.getStatus());
//			detailsRepository.save(donorEntity2);
//		} else {
//			try {
//				throw new DonationDetailsNotFoundException(
//						"Details are not available to update with this " + donorBean.getDonationId());
//			} catch (DonationDetailsNotFoundException e) {
//				throw e;
//			}
//		}
//	}
//
//	@Override
//	public void delete(Long id) {
////		donorRepository.deleteById(id);
//
//		Optional<DonorDetailsEntity> findById = detailsRepository.findById(id);
//		if (findById.isEmpty()) {
//			try {
//				findById.orElseThrow(
//						() -> new DonationDetailsNotFoundException("details are  is  not found to delete"));
//			} catch (DonationDetailsNotFoundException e) {
//				throw e;
//			}
//		} else {
//			detailsRepository.deleteById(id);
//		}
//	}
//
//	@Override
//	public List<DonorDetailsBean> getAllDonors() {
//		List<DonorDetailsEntity> entities = detailsRepository.findAll();
//		List<DonorDetailsBean> beans = new ArrayList<>();
//		entityToBeanList(entities, beans);
//		return beans;
//	}
//
//	public void entityToBean(DonorDetailsEntity donorEntity, DonorDetailsBean donorBean) {
//		donorBean.setDonationId(donorEntity.getDonationId());
//		donorBean.setBloodQuantity(donorEntity.getBloodQuantity());
//		donorBean.setDateOfDonation(donorEntity.getDateOfDonation());
//		donorBean.setStatus(donorEntity.getStatus());
//	}
//
//	public void beanToEntity(DonorDetailsEntity donorEntity, DonorDetailsBean donorBean) {
//		donorEntity.setDonationId(donorBean.getDonationId());
//		donorEntity.setBloodQuantity(donorBean.getBloodQuantity());
//		donorEntity.setDateOfDonation(donorBean.getDateOfDonation());
//		donorEntity.setStatus(donorBean.getStatus());
//	}
//
//	public void entityToBeanList(List<DonorDetailsEntity> donorEntity, List<DonorDetailsBean> donorBean) {
//
//		for (DonorDetailsEntity donorEntity2 : donorEntity) {
//
//			DonorDetailsBean bean = new DonorDetailsBean();
//			bean.setDonationId(donorEntity2.getDonationId());
//			bean.setBloodQuantity(donorEntity2.getBloodQuantity());
//			bean.setDateOfDonation(donorEntity2.getDateOfDonation());
//			bean.setStatus(donorEntity2.getStatus());
//			donorBean.add(bean);
//		}
	}

////	@Override
////	public DonorDetailsEntity save(DonorDetailsEntity donorEntity) {
////		return detailsRepository.save(donorEntity);
////	}
//
//	@Override
//	public void save(DonorDetailsBean detailsBean) {
//		
//		DonorDetailsEntity detailsEntity = new DonorDetailsEntity();
//		
//		detailsEntity.setBloodQuantity(detailsBean.getBloodQuantity());
//		detailsEntity.setDateOfDonation(detailsBean.getDateOfDonation());
//		detailsEntity.setStatus(detailsBean.getStatus());
//		
//		detailsRepository.save(detailsEntity);
//	}
//
//	
//	@Override
////	public Optional<DonorDetailsEntity> getById(Long id) {
//	public DonorDetailsEntity getById(Long id) {
////		return detailsRepository.findById(id);
//
//		Optional<DonorDetailsEntity> findById = detailsRepository.findById(id);
//		if (findById.isEmpty()) {
//			try {
//				findById.orElseThrow(() -> new DonationDetailsNotFoundException("donation id is not found to get"));
//			} catch (DonationDetailsNotFoundException e) {
//				throw e;
//			}
//		}
//		return findById.get();
//	}
//
//	@Override
//	public Optional<DonorDetailsEntity> update(DonorDetailsEntity donorEntity) {
//		Optional<DonorDetailsEntity> findById = detailsRepository.findById(donorEntity.getDonationId());
//
//		if (findById.isPresent()) {
//			detailsRepository.save(donorEntity);
//			return findById;
//		} else {
////			System.out.println("incorrect id");
//				findById.orElseThrow(() -> new DonationDetailsNotFoundException("donation id is  not found to update"));
//		}
//		return null;
//	}
//
//	@Override
//	public void delete(Long id) {
////		detailsRepository.deleteById(id);
//		Optional<DonorDetailsEntity> findById = detailsRepository.findById(id);
//		if (findById.isEmpty()) {
//			try {
//				findById.orElseThrow(() -> new DonationDetailsNotFoundException("donation id is  not found to delete"));
//			} catch (DonationDetailsNotFoundException e) {
//				throw e;
//			}
//		} else {
//			detailsRepository.deleteById(id);
//		}
//	}
//
//	@Override
//	public List<DonorDetailsEntity> getAll() {
//		return detailsRepository.findAll();
//	}
