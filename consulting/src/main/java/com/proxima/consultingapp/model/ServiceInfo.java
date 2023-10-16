package com.proxima.consultingapp.model;

import java.math.BigDecimal;
import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="serviceinfo")
public class ServiceInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long serviceId;
	private String serviceName;
	private String serviceDescription;	
	private BigDecimal amount;
	private boolean active = true;



	public ServiceInfo() {
		super();
	}
	
	
	public ServiceInfo(String serviceName, String serviceDescription, BigDecimal amount) {
		super();
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
	}
	
	public ServiceInfo(Long serviceId, String serviceName, String serviceDescription, BigDecimal amount) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
	}


//	public Long getServiceId() {
//		return serviceId;
//	}
//
//
//
//	public void setServiceId(Long serviceId) {
//		this.serviceId = serviceId;
//	}
//
//
//
//	public String getServiceName() {
//		return serviceName;
//	}
//
//
//
//	public void setServiceName(String serviceName) {
//		this.serviceName = serviceName;
//	}
//
//
//
//	public String getServiceDescription() {
//		return serviceDescription;
//	}
//
//
//
//	public void setServiceDescription(String serviceDescription) {
//		this.serviceDescription = serviceDescription;
//	}
//
//
//
//	public BigDecimal getAmount() {
//		return amount;
//	}
//
//
//
//	public void setAmount(BigDecimal amount) {
//		this.amount = amount;
//	}
//
//
//	public boolean isActive() {
//		return active;
//	}
//
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//
//
//	@Override
//	public String toString() {
//		return "ServiceInfo [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
//				+ serviceDescription + ", amount=" + amount + "]";
//	}
	
	

	
}
