package com.example.major.dto;

import java.time.LocalDate;

public class BillPayment {
	
	private Long planID;
	
	private String planName;
	
	private LocalDate cycleStartDate; 

	private LocalDate cycledueDate;

	private LocalDate paymentDate;
	
	private Long amount;
	
	private String customerName;
	
	private String billStatus;
	
	private int No_months = 1;

	public BillPayment() {
		
	}
	
	public BillPayment(Long planID, String planName, LocalDate dueDate, LocalDate paymentDate, Long amount) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.cycledueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	


	

	public BillPayment(Long planID, String planName, LocalDate dueDate, LocalDate paymentDate, Long amount,
			String customerName, String billStatus) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.cycledueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customerName = customerName;
		this.billStatus = billStatus;
	}
	
	
	
	
	

	public BillPayment(Long planID, String planName, LocalDate cycleStartDate, LocalDate cycledueDate,
			LocalDate paymentDate, Long amount, String customerName, String billStatus, int no_months) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.cycleStartDate = cycleStartDate;
		this.cycledueDate = cycledueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customerName = customerName;
		this.billStatus = billStatus;
		this.No_months = no_months;
	}

	public BillPayment(Long planID, String planName, LocalDate cycleStartDate, LocalDate cycledueDate,
			LocalDate paymentDate, Long amount, String customerName, String billStatus) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.cycleStartDate = cycleStartDate;
		this.cycledueDate = cycledueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customerName = customerName;
		this.billStatus = billStatus;
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


	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getCycleStartDate() {
		return cycleStartDate;
	}

	public void setCycleStartDate(LocalDate cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}
	
	public int getNo_months() {
		return No_months;
	}

	public void setNo_months(int no_months) {
		No_months = no_months;
	}

	@Override
	public String toString() {
		return "BillPayment [planID=" + planID + ", planName=" + planName + ", cycleStartDate=" + cycleStartDate
				+ ", cycledueDate=" + cycledueDate + ", paymentDate=" + paymentDate + ", amount=" + amount
				+ ", customerName=" + customerName + ", billStatus=" + billStatus + ", No_months=" + No_months + "]";
	}


	
	
	

	
	
	
	
	
	
	
	
	
}
