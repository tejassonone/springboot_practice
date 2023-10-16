package com.proxima.consultingapp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proxima.consultingapp.model.ServiceInfo;
import com.proxima.consultingapp.service.ServiceInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("services")
public class ServiceInfoController {
	@Autowired
	private ServiceInfoService serviceInfoService;
	
	
	@GetMapping("")
	public List<ServiceInfo> getConsultantServices() {
		return serviceInfoService.getAllServices();
	}
	
	@GetMapping(path="{id}")
	public ResponseEntity<ServiceInfo> getServiceInfoById(@PathVariable("id") Long id) {
		ServiceInfo serviceInfo = serviceInfoService.getServiceById(id);
		if(serviceInfo!=null) {
			return ResponseEntity.ok(serviceInfo);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("")
	public ResponseEntity<ServiceInfo> createServiceInfo(@RequestBody ServiceInfo serviceInfo) {
		ServiceInfo createdService = serviceInfoService.createService(serviceInfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceInfo);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ServiceInfo> updateServiceInfo(
			@PathVariable Long id, @RequestBody ServiceInfo updateServiceInfo){
		ServiceInfo updateService = serviceInfoService.updateService(id, updateServiceInfo);
		if(updateService!=null) {
			return ResponseEntity.ok(updateService);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id){
		if(serviceInfoService.deleteService(id)) {
			return ResponseEntity.ok("Service deleted successfully");
		}
		return ResponseEntity.notFound().build();
	}
	
}
