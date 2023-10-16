package com.proxima.consultingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proxima.consultingapp.model.ServiceInfo;

@Repository
public interface ServiceInfoRepo extends JpaRepository<ServiceInfo, Long>{
	
}
