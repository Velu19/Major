package com.example.major.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.major.entity.Bills;
import com.example.major.entity.Plans;
import com.example.major.repository.BillRepository;
import com.example.major.repository.PlanRepository;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class ScheduleService {
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private BillRepository billrepository;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void testing() {
		
		
		List<Plans> plans = planRepository.findAll();
		for(int i=0;i<plans.size();i++) {
			long daysleft = plans.get(i).getDayLeft();
			System.out.println(daysleft);
			if( daysleft<=4 && daysleft >1 ) {
				MessageReminder(plans.get(i).getCustomer().getphonenumber(),plans.get(i).getDayLeft(),plans.get(i).getPlanName());
			}
			else if(daysleft ==1) {
				MessageTommorow(plans.get(i).getCustomer().getphonenumber(),plans.get(i).getPlanName());

			}
			else if(daysleft==0) {
				MessageToday(plans.get(i).getCustomer().getphonenumber(),plans.get(i).getPlanName());
			}
			else if(daysleft<0 && daysleft>-5){
				MessageExpiryReminder(plans.get(i).getCustomer().getphonenumber(),plans.get(i).getPlanName());
				
			}
			else if(daysleft == -5 ) {
				ExpireService(plans.get(i).getCustomer().getphonenumber(),plans.get(i).getPlanName());
				System.out.println("discontinue service and apply fine later using logics");
				Plans discontinue = plans.get(i);
				discontinue.setServiceTrue(false);
				planRepository.save(discontinue);
			}
			else if(daysleft <-5) {
				Plans discontinue = plans.get(i);
				discontinue.setServiceTrue(false);
				planRepository.save(discontinue);
			}
			
			
			
			
			
			
		}
		
		
//		List<Bills> bill = billrepository.findAll();
//		for(int i=0;i<bill.size();i++) {
//			System.out.println(bill.get);
//		}
	}
	
	
	
	
	private void ExpireService(String getphonenumber, String planName) {
		// TODO Auto-generated method stub
		
//		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
//		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	     Message message = Message.creator(
//	       new com.twilio.type.PhoneNumber(getphonenumber),
//	       new com.twilio.type.PhoneNumber("+14846051673"),
//	       "Your "+ planName +" plan has been discontinued"+ System.lineSeparator() + "Please pay your bill soon to continue enjoying our services" )
//	     .create();
//	     
//	     
//	     System.out.println("message sent");
//	     System.out.println(message.getSid());	
//		
	}




	private void MessageExpiryReminder(String getphonenumber, String planName) {
		// TODO Auto-generated method stub
//		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
//		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	     Message message = Message.creator(
//	       new com.twilio.type.PhoneNumber(getphonenumber),
//	       new com.twilio.type.PhoneNumber("+14846051673"),
//	       "Your "+ planName +" plan has expired "+ System.lineSeparator() + "Please pay your bill soon to continue enjoying our services" )
//	     .create();
//	     
//	     
//	     System.out.println("message sent");
//	     System.out.println(message.getSid());	
//	     
	}




	private void MessageToday(String getphonenumber, String planName) {
		// TODO Auto-generated method stub
		
//		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
//		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	     Message message = Message.creator(
//	       new com.twilio.type.PhoneNumber(getphonenumber),
//	       new com.twilio.type.PhoneNumber("+14846051673"),
//	       "Your "+ planName +" plan is expiring today "+ System.lineSeparator() + "Please pay your bill today to continue enjoying our services" )
//	     .create();
//	     
//	     
//	     System.out.println("message sent");
//	     System.out.println(message.getSid());	
//		
	}




	private void MessageTommorow(String getphonenumber, String planName) {
		// TODO Auto-generated method stub
		
//		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
//		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	     Message message = Message.creator(
//	       new com.twilio.type.PhoneNumber(getphonenumber),
//	       new com.twilio.type.PhoneNumber("+14846051673"),
//	       "Your "+ planName +" plan is expiring tommorow "+ System.lineSeparator() + "Please pay your bill soon to continue enjoying our services" )
//	     .create();
//	     
//	     
//	     System.out.println("message sent");
//	     System.out.println(message.getSid());	
	}




	public void MessageReminder(String customernum, Long daysleft, String plansname) {
		//this code below connects to twilio and generates OTP
		
//		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
//		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	     Message message = Message.creator(
//	       new com.twilio.type.PhoneNumber(customernum),
//	       new com.twilio.type.PhoneNumber("+14846051673"),
//	       "Your "+ plansname +" plan is expiring in " + daysleft + " days"+ System.lineSeparator() + "Please pay your bill soon to continue enjoying our services" )
//	     .create();
//	     
//	     
//	     System.out.println("message sent");
//	     System.out.println(message.getSid());		
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
}
