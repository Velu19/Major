package com.example.major.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "plans")
public class Plans {
	
	@Id
	@SequenceGenerator(
			name="plan_sequence",
			sequenceName = "plan_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "plan_sequence"
	)
	private Long planID;
	
	
	private String planName;
	
	private String speed;
	
	private String dataLimit;
	
	private String dataUsed;
	
	
	@Transient
	private String dataLeft;
	
	@Transient
	private Long dayLeft;
	
	@Transient
	private String blinkLight;
	
	private int price;
	
	
	private boolean serviceTrue;
	
	
	@JsonBackReference("customers-plans")
	@ManyToOne
	@JoinColumn(name = "customer_accountNumber")
	private Customers customer;
	
	
	@JsonManagedReference("plans-routers")
	@OneToOne(mappedBy = "plans", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Routers router;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "plans", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Bills bills;
	
	
	public Plans()
	{
		
	}

	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
	}

	public Plans(Long planID, String planName, String speed, String dataLimit, int price) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
	}

	public Plans(String planName, String speed, String dataLimit, int price) {
		super();
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
	}
	
	
	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer,
			Routers router) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
		this.router = router;
	}
	
	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer,
			Routers router, Bills bills) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
		this.router = router;
		this.bills = bills;
	}
	
	
	
	//constructor after creating dataused
	
	public Plans(String planName, String speed, String dataLimit, String dataUsed, int price) {
		super();
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.dataUsed = dataUsed;
		this.price = price;
	}
	
	
	
	

	public Plans(String planName, String speed, String dataLimit, String dataUsed, int price, boolean serviceTrue) {
		super();
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.dataUsed = dataUsed;
		this.price = price;
		this.serviceTrue = serviceTrue;
	}

	public Long getPlanID() {
		return planID;
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

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(String dataLimit) {
		this.dataLimit = dataLimit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	

	public Routers getRouter() {
		return router;
	}

	public void setRouter(Routers router) {
		this.router = router;
	}
		
	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}
	
	public String getDataUsed() {
		return dataUsed;
	}

	public void setDataUsed(String dataUsed) {
		this.dataUsed = dataUsed;
	}
	
	public String getDataLeft() {

		//System.out.println("hello");
		String data1 = this.dataLimit.substring(0,this.dataLimit.length()-2);
		//System.out.println(data1);
		String data2 = this.dataUsed.substring(0,this.dataUsed.length()-2);
//		System.out.println(data2);
//		System.out.println(data1);
//		System.out.println(data2);
		
		BigDecimal datalimitbig = new BigDecimal(data1);
		BigDecimal datausedbig = new BigDecimal(data2);
		
		BigDecimal dataleft = datalimitbig.subtract(datausedbig);
		//System.out.println(dataleft);
//		Integer datalimitint = Integer.parseInt(data1);
//		Integer datausedint = Integer.parseInt(data2);
//		Integer dataleft = datalimitint-datausedint;
//		System.out.println(dataleft);
		String Data = dataleft.toString();
		if(dataleft.compareTo(BigDecimal.ZERO) > 0) {
			Data+="GB";
		}
		else {
			Data = "0GB";
		}

		return Data;
	}
	
	
	

	public void setDataLeft(String dataLeft) {
		this.dataLeft = dataLeft;
	}
	
	public Long getDayLeft() {
		Long days = Duration.between(LocalDate.now().atStartOfDay(),this.bills.getDueDate().atStartOfDay()).toDays();
		System.out.println(days + "hello by days");
		return  Duration.between(LocalDate.now().atStartOfDay(),this.bills.getDueDate().atStartOfDay()).toDays();
	}

	public void setDayLeft(Long dayLeft) {
		this.dayLeft = dayLeft;
	}
	
	public boolean isServiceTrue() {
		return serviceTrue;
	}

	public void setServiceTrue(boolean serviceTrue) {
		this.serviceTrue = serviceTrue;
	}
	
	
	public String getBlinkLight() {
		Long days = Duration.between(LocalDate.now().atStartOfDay(),this.bills.getDueDate().atStartOfDay()).toDays();
		if(days > 4) {
			return "Blue";
		}
		else if(days <=4 && days>=-4 ) {
			return "near expiry";
		}
		else {
			return "expiry";
		}			
	}

	public void setBlinkLight(String blinkLight) {
		this.blinkLight = blinkLight;
	}

	@Override
	public String toString() {
		return "Plans [planID=" + planID + ", planName=" + planName + ", speed=" + speed + ", dataLimit=" + dataLimit
				+ ", dataUsed=" + dataUsed + ", dataLeft=" + dataLeft + ", dayLeft=" + dayLeft + ", price=" + price
				+ ", serviceTrue=" + serviceTrue + ", router=" + router + ", bills=" + bills + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
