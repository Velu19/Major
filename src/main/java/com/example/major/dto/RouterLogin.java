package com.example.major.dto;

import java.util.Random;

import lombok.Data;


public class RouterLogin {
	
	private String randomdevice() {
		
		String[] arr={"Android","Iphone","Laptop"};
		Random r=new Random(); 
        int randomNumber=r.nextInt(arr.length); 
        String type = arr[randomNumber];
        
		return type;	

	}
	
	
	
	private String ssid;
	
	private String password;
	
	
	private String mac;
	
	private String deviceType = randomdevice();
	
	private String datause ;
	
	
	public RouterLogin() {
		
	}

	public RouterLogin(String ssid, String password, String mac, String deviceType) {
		super();
		this.ssid = ssid;
		this.password = password;
		this.mac = mac;
		this.deviceType = deviceType;
	}
	
	
	

	public RouterLogin(String ssid, String password, String mac, String deviceType, String datause) {
		super();
		this.ssid = ssid;
		this.password = password;
		this.mac = mac;
		this.deviceType = deviceType;
		this.datause = datause;
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
	
	public String getDatause() {
		return datause;
	}

	public void setDatause(String datause) {
		this.datause = datause;
	}

	
	@Override
	public String toString() {
		return "RouterLogin [ssid=" + ssid + ", password=" + password + ", mac=" + mac + ", deviceType=" + deviceType
				+ ", datause=" + datause + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
