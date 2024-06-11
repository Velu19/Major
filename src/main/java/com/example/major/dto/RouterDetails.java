package com.example.major.dto;

public class RouterDetails {
	
	private Long planID;
	
	private String planName; 
	
	private Long routerID;
	
	private String serialNumber;
	
	private String model;
	
	private String firmwareVersion;

	private String ssid;
	
	private String password;
	
	private String ipv4;
	
	private String deviceId;
	
	public RouterDetails(){
		
	}

//	public RouterDetails(Long planID, Long planName) {
//		super();
//		this.planID = planID;
//		this.planName = planName;
//	}

	

	public Long getPlanID() {
		return planID;
	}

	public RouterDetails(Long planID, String planName, Long routerID, String serialNumber, String model,
		String firmwareVersion, String ssid, String password, String ipv4) {
	super();
	this.planID = planID;
	this.planName = planName;
	this.routerID = routerID;
	this.serialNumber = serialNumber;
	this.model = model;
	this.firmwareVersion = firmwareVersion;
	this.ssid = ssid;
	this.password = password;
	this.ipv4 = ipv4;
	}
	
	public RouterDetails(Long planID, String planName, Long routerID, String serialNumber, String model,
			String firmwareVersion, String ssid, String password, String ipv4, String deviceId) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.routerID = routerID;
		this.serialNumber = serialNumber;
		this.model = model;
		this.firmwareVersion = firmwareVersion;
		this.ssid = ssid;
		this.password = password;
		this.ipv4 = ipv4;
		this.deviceId = deviceId;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getRouterID() {
		return routerID;
	}

	public void setRouterID(Long routerID) {
		this.routerID = routerID;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "RouterDetails [planID=" + planID + ", planName=" + planName + ", routerID=" + routerID
				+ ", serialNumber=" + serialNumber + ", model=" + model + ", firmwareVersion=" + firmwareVersion
				+ ", ssid=" + ssid + ", password=" + password + ", ipv4=" + ipv4 + ", deviceId=" + deviceId + "]";
	}
	
	

	
	

}
