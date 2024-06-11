package com.example.major.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="routers")
public class Routers {
	
	
	@Id
	@SequenceGenerator(
			name="router_sequence",
			sequenceName = "router_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "router_sequence"
	)
	private Long routerID;
	
	
	private int accountNumber;
	
	@Column(unique=true)
	private String serialNumber;
	
	
	private String model;
	
	private String firmwareVersion;
	
	
	private String ipv4;
	
	@Column(unique=true)
	private String ssid;
	
	
	private String password;
	

    
	
	
	
	
//	@OneToMany(targetEntity = Devices.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "routerFk",referencedColumnName = "routerID")
	
	
	@JsonManagedReference("routers-devices")
	@OneToMany(mappedBy="router", cascade = CascadeType.ALL)
	private List<Devices> devices;
	
	
	
	@JsonBackReference("plans-routers")
	@OneToOne
    @MapsId
    @JoinColumn(name = "plan_id")
	private Plans plans;
	
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	
	public Routers() {
		
	}

	public Routers(int accountNumber, String serialNumber, String model, String firmwareVersion, String ipv4,
			String ssid, String password, List<Devices> devices) {
		super();
		this.accountNumber = accountNumber;
		this.serialNumber = serialNumber;
		this.model = model;
		this.firmwareVersion = firmwareVersion;
		this.ipv4 = ipv4;
		this.ssid = ssid;
		this.password = password;
		this.devices = devices;
	}
	public Routers(Long routerID, int accountNumber, String serialNumber, String model, String firmwareVersion, String ipv4,
			String ssid, String password, List<Devices> devices) {
		super();
		this.routerID = routerID;
		this.accountNumber = accountNumber;
		this.serialNumber = serialNumber;
		this.model = model;
		this.firmwareVersion = firmwareVersion;
		this.ipv4 = ipv4;
		this.ssid = ssid;
		this.password = password;
		this.devices = devices;
	}
	
	
	public Routers(int accountNumber, String serialNumber, String model, String firmwareVersion, String ipv4,
			String ssid, String password) {
		super();
		this.accountNumber = accountNumber;
		this.serialNumber = serialNumber;
		this.model = model;
		this.firmwareVersion = firmwareVersion;
		this.ipv4 = ipv4;
		this.ssid = ssid;
		this.password = password;
	}
	
	
	
	

	public Routers(Long routerID, int accountNumber, String serialNumber, String model, String firmwareVersion,
			String ipv4, String ssid, String password, List<Devices> devices, Plans plans) {
		super();
		this.routerID = routerID;
		this.accountNumber = accountNumber;
		this.serialNumber = serialNumber;
		this.model = model;
		this.firmwareVersion = firmwareVersion;
		this.ipv4 = ipv4;
		this.ssid = ssid;
		this.password = password;
		this.devices = devices;
		this.plans = plans;
	}
	
	

	public Long getRouterID() {
		return routerID;
	}


public void setRouterID(Long routerID) {
	this.routerID = routerID;
}


public int getAccountNumber() {
	return accountNumber;
}


public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
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


public String getIpv4() {
	return ipv4;
}


public void setIpv4(String ipv4) {
	this.ipv4 = ipv4;
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


public List<Devices> getDevices() {
	return devices;
}


public void setDevices(List<Devices> devices) {
	this.devices = devices;
}





public Plans getPlans() {
	return plans;
}

public void setPlans(Plans plans) {
	this.plans = plans;
}


public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

@Override
public String toString() {
	return "Routers [routerID=" + routerID + ", accountNumber=" + accountNumber + ", serialNumber=" + serialNumber
			+ ", model=" + model + ", firmwareVersion=" + firmwareVersion + ", ipv4=" + ipv4 + ", ssid=" + ssid
			+ ", password=" + password + ", devices=" + devices + "]";
}


	
	



	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
}
