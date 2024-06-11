package com.example.major.entity;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Bills {
	
	@Id
	@SequenceGenerator(
			name="bill_sequence",
			sequenceName = "bill_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "bill_sequence"
	)
	private Long billID;
	
	private LocalDate cycledueDate;
	
	private LocalDate cycleStartDate;
	
	private LocalDate paymentDate;
	

	
	
	
	@JsonBackReference
	@OneToOne
    @MapsId
    @JoinColumn(name = "plan_id")
	private Plans plans;
	
	public Bills() {
		
	}
	


	public Bills(Long billID, LocalDate cycledueDate, LocalDate cycleStartDate, LocalDate paymentDate, Plans plans) {
		super();
		this.billID = billID;
		this.cycledueDate = cycledueDate;
		this.cycleStartDate = cycleStartDate;
		this.paymentDate = paymentDate;
		this.plans = plans;
	}

	public Bills(Long billID, LocalDate cycledueDate, LocalDate cycleStartDate, LocalDate paymentDate) {
		super();
		this.billID = billID;
		this.cycledueDate = cycledueDate;
		this.cycleStartDate = cycleStartDate;
		this.paymentDate = paymentDate;
	}



	public Bills(LocalDate dueDate, LocalDate paymentDate) {
		super();
		this.cycledueDate = dueDate;
		this.paymentDate = paymentDate;
	}


	public Long getBillID() {
		return billID;
	}


	public void setBillID(Long billID) {
		this.billID = billID;
	}


	public LocalDate getDueDate() {
		return cycledueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.cycledueDate = dueDate;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	public LocalDate getCycleStartDate() {
		return cycleStartDate;
	}



	public void setCycleStartDate(LocalDate cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}



	public Plans getPlans() {
		return plans;
	}


	public void setPlans(Plans plans) {
		this.plans = plans;
	}



	@Override
	public String toString() {
		return "Bills [billID=" + billID + ", cycledueDate=" + cycledueDate + ", cycleStartDate=" + cycleStartDate
				+ ", paymentDate=" + paymentDate + ", plans=" + plans + "]";
	}


	

	

	
	
	
	
	
	
	

	
	
	
}
