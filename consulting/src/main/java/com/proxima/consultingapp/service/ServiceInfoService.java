package com.proxima.consultingapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proxima.consultingapp.model.ServiceInfo;
import com.proxima.consultingapp.repo.ServiceInfoRepo;



@Service
public class ServiceInfoService {
	@Autowired
	private ServiceInfoRepo serviceInfoRepo;
	

	public List<ServiceInfo> getAllServices() {
		return serviceInfoRepo.findAll();
	}


	public ServiceInfo getServiceById(Long id) {
		return serviceInfoRepo.findById(id).orElse(null);
	}


	public ServiceInfo createService(ServiceInfo serviceInfo) {
		return serviceInfoRepo.save(serviceInfo);
	}


	public ServiceInfo updateService(Long id, ServiceInfo updateServiceInfo) {
		if(serviceInfoRepo.existsById(id)) {
			updateServiceInfo.setServiceId(id);
			return serviceInfoRepo.save(updateServiceInfo);
		}
		return null;
	}


	public boolean deleteService(Long id) {
		ServiceInfo serviceInfo = serviceInfoRepo.findById(id).get();
		if(serviceInfo!=null) {
			if(serviceInfo.isActive()) {
				serviceInfo.setActive(false);
				serviceInfoRepo.save(serviceInfo);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
