package com.example.major.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name = "devices")
public class Devices {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long connectedDevice; 
	
	
	private String deviceId;
	
	private String mac;
	
	private String deviceType;
		
	private Boolean isBlocked;
	
	
// 	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	//@JoinColumn(name = "Routers_routerID", nullable = false)
	
	@JsonBackReference("routers-devices")
	@ManyToOne
	@JoinColumn(name = "router_routerID")
	private Routers router;

	
	
	public Devices() {
		
	}
	
	


	public Devices(Long connectedDevice, String deviceId, String mac, String deviceType, Routers router) {
		super();
		this.connectedDevice = connectedDevice;
		this.deviceId = deviceId;
		this.mac = mac;
		this.deviceType = deviceType;
		this.router = router;
	}



	public Devices(String deviceId, String mac, String deviceType, Routers router) {
		super();
		this.deviceId = deviceId;
		this.mac = mac;
		this.deviceType = deviceType;
		this.router = router;
	}
	
	public Devices(Long connectedDevice, String deviceId, String mac, String deviceType, Boolean isBlocked,
			Routers router) {
		super();
		this.connectedDevice = connectedDevice;
		this.deviceId = deviceId;
		this.mac = mac;
		this.deviceType = deviceType;
		this.isBlocked = isBlocked;
		this.router = router;
	}




	public Long getConnectedDevice() {
		return connectedDevice;
	}



	public void setConnectedDevice(Long connectedDevice) {
		this.connectedDevice = connectedDevice;
	}



	public String getDeviceId() {
		return deviceId;
	}



	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}



	public String getMac() {
		return mac;
	}



	public void setMac(String mac) {
		this.mac = mac;
	}



	public String getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}



	public Routers getRouter() {
		return router;
	}



	public void setRouter(Routers router) {
		this.router = router;
	}


	public Boolean getIsBlocked() {
		return isBlocked;
	}




	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}




	@Override
	public String toString() {
		return "Devices [connectedDevice=" + connectedDevice + ", deviceId=" + deviceId + ", mac=" + mac
				+ ", deviceType=" + deviceType + ", isBlocked=" + isBlocked + "]";
	}
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
