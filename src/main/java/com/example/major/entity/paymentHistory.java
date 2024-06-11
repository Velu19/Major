package com.example.major.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class paymentHistory {
	
	
	@Id
	@SequenceGenerator(
			name="history_sequence",
			sequenceName = "history_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "history_sequence"
	)
	private Long paymentHistory;
	
	private Long final_amount;
	
	private String paymentType;
	
	private LocalDate dueDate;
	
	private String planName;
	
	private LocalDate paymentDate;
	
	
	private Long planID;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_accountNumber")
	private Customers customerhistory;
	
	
	
	public paymentHistory() {
		
	}



	public paymentHistory(Long paymentHistory, Long final_amount, String paymentType, LocalDate dueDate,
			LocalDate paymentDate, Long planID, Customers customerhistory) {
		super();
		this.paymentHistory = paymentHistory;
		this.final_amount = final_amount;
		this.paymentType = paymentType;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.planID = planID;
		this.customerhistory = customerhistory;
	}



	public paymentHistory(Long final_amount, String paymentType, LocalDate dueDate, String planName,
			LocalDate paymentDate, Long planID) {
		super();
		this.final_amount = final_amount;
		this.paymentType = paymentType;
		this.dueDate = dueDate;
		this.planName = planName;
		this.paymentDate = paymentDate;
		this.planID = planID;
	}



	public paymentHistory(Long final_amount, String paymentType, LocalDate dueDate, LocalDate paymentDate, Long planID,
			Customers customerhistory) {
		super();
		this.final_amount = final_amount;
		this.paymentType = paymentType;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.planID = planID;
		this.customerhistory = customerhistory;
	}



	public Long getPaymentHistory() {
		return paymentHistory;
	}



	public void setPaymentHistory(Long paymentHistory) {
		this.paymentHistory = paymentHistory;
	}



	public Long getFinal_amount() {
		return final_amount;
	}



	public void setFinal_amount(Long final_amount) {
		this.final_amount = final_amount;
	}



	public String getPaymentType() {
		return paymentType;
	}



	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}



	public LocalDate getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}



	public Long getPlanID() {
		return planID;
	}



	public void setPlanID(Long planID) {
		this.planID = planID;
	}



	public Customers getCustomerhistory() {
		return customerhistory;
	}



	public void setCustomerhistory(Customers customerhistory) {
		this.customerhistory = customerhistory;
	}

	
	public String getPlanName() {
		return planName;
	}



	public void setPlanName(String planName) {
		this.planName = planName;
	}



	@Override
	public String toString() {
		return "paymentHistory [paymentHistory=" + paymentHistory + ", final_amount=" + final_amount + ", paymentType="
				+ paymentType + ", dueDate=" + dueDate + ", planName=" + planName + ", paymentDate=" + paymentDate
				+ ", planID=" + planID + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
