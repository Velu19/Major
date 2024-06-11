package com.example.major.service;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.major.dto.BillPayment;
import com.example.major.dto.RouterDetails;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.entity.paymentHistory;
import com.example.major.entity.users;
import com.example.major.repository.BillRepository;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;
import com.example.major.repository.RouterRepository;
import com.example.major.repository.paymentHistoryRepository;

import jakarta.transaction.Transactional;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired 
	private RouterRepository routerRepository; 
	
	@Autowired
	private  DeviceRepository deviceRepository;
	
	@Autowired
	private paymentHistoryRepository paymenthistory;
	
	@Autowired
	private BillRepository billrepository;
	
	
	
//	@Autowired
//	public CustomerService(CustomerRepository customerRepository) {
//		this.customerRepository = customerRepository;
//	}

	public List<Customers> getall() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


	public ResponseEntity<String> CustomerValidation(Customers customer) {
		System.out.println(customer);

		Optional<Customers> current = customerRepository.findCustomerByaccountNum(customer.getAccountNumber());
		Optional<Customers> current1 = customerRepository.findCustomerByName(customer.getName());
		if(current.isPresent()) {
			System.out.println(current);
			Customers check = current.get();
			if(check.getName().equals(customer.getName())){

				return (ResponseEntity<String>) ResponseEntity.ok("Login Successfull");

			}
			else if(current1.isPresent())
			{
				return (ResponseEntity<String>) ResponseEntity.ok("Account holder name/number is incorrect");
			}
			else{
				return (ResponseEntity<String>) ResponseEntity.ok("Account holder name is wrong");
			}

		}
		else {
			return (ResponseEntity<String>) ResponseEntity.ok("account number does not exist");

		}


 

	}
	
	public Customers getphoneEmail(Customers customer) {

		// TODO Auto-generated method stub
		System.out.println(customer.getAccountNumber());
		 Optional<Customers> acctcheck = customerRepository.findCustomerByaccountNum(customer.getAccountNumber());
		 Customers c = new Customers();
		 if(acctcheck.isPresent()) {
			  c = acctcheck.get();
		 }
		

		 Customers cust = new Customers();

		 cust.setEmail(c.getEmail());

		 cust.setphonenumber(c.getphonenumber());

		 cust.setName(c.getName());

		 //cust.setphonenumber(c.getphonenumber());

		 System.out.print(cust);

		 return cust;

	}

	public List<Plans> getplans(Customers customer) {
		// TODO Auto-generated method stub
		Optional<Customers> ifexists = customerRepository.findCustomerByEmail(customer.getEmail());
		Optional<Customers> ifexistsphone = customerRepository.findCustomerByPhone(customer.getEmail());
		if(ifexists.isPresent()) {
			Customers existing = ifexists.get();
			System.out.println("hello");
			return (List<Plans>) existing.getPlans();
		}
		else if(ifexistsphone.isPresent()) {
			Customers existing = ifexistsphone.get();
			System.out.println("hello");
			return (List<Plans>) existing.getPlans();	
		}
		return null;
	}


	public Object getRouterDetails(Customers customer) {
			Optional<Customers> cust = customerRepository.findCustomerByEmail(customer.getEmail()) ;
			List<RouterDetails> sendRouters=  new ArrayList();
			if(cust.isPresent()) {
				Customers existing = cust.get();
				System.out.println("Customer exists");
				List<Plans> planlist = existing.getPlans(); 
				if(planlist.isEmpty()) {
					return null;
				}
				
				for(int i=0;i<planlist.size();i++) {
//					if(planlist.get(i).getRouter() == null) {
//						System.out.println("router not exists");					
//					}
//					else {
//						System.out.println("router exists");
//					}
					
					if(Objects.isNull(planlist.get(i).getRouter())) {
						System.out.println("this gets skipped");
					}
					else {
						RouterDetails router = new RouterDetails();
						
						router.setPlanID(planlist.get(i).getPlanID());
						router.setPlanName(planlist.get(i).getPlanName());
						router.setRouterID(planlist.get(i).getRouter().getRouterID());
						router.setSerialNumber(planlist.get(i).getRouter().getSerialNumber());
						router.setModel(planlist.get(i).getRouter().getModel());
						router.setFirmwareVersion(planlist.get(i).getRouter().getFirmwareVersion());
						router.setSsid(planlist.get(i).getRouter().getSsid());
						router.setPassword(planlist.get(i).getRouter().getPassword());
						router.setIpv4(planlist.get(i).getRouter().getIpv4());
						
						sendRouters.add(router);
					}

				}
			}
			
			return sendRouters;
		}

	
	@Transactional
	public String updateRouterDetails(RouterDetails router) {
		System.out.println(router.getPassword());
		Optional <Routers> exists = routerRepository.findbyserialNumber(router.getSerialNumber());
		if(exists.isPresent()) {
			Routers current = exists.get();
			//System.out.println(router.getPassword());
			//System.out.println(current.getPassword());
			if(!router.getPassword().equals(current.getPassword()) ) {
				System.out.println("password updated");
				for(int i=0;i<current.getDevices().size();i++) {
					
					//if(Objects.isNull(planlist.get(i).getRouter())) 
					if(Objects.isNull(current.getDevices().get(i))) {
						System.out.println("Ended");
					}
					else {
						
						Long idnew = current.getDevices().get(i).getConnectedDevice();
						
						//System.out.println(idnew);
						//System.out.println(current.getDevices().get(i).getMac());
						current.getDevices().get(i).setRouter(null);
						
						deviceRepository.deleteById(idnew);
						
						
					}
				}
				current.setDevices(null);
			}
			
			current.setPassword(router.getPassword());
			current.setIpv4(router.getIpv4());
			current.setSsid(router.getSsid());
			current.setFirmwareVersion(router.getFirmwareVersion());
			routerRepository.save(current);
			
			//System.out.println(current.getDevices().get(0));
			System.out.println("Updated successfully");
			
		}
		
		
		
		
		
		return null;
		
		// TODO Auto-generated method stub
		
	}


	public List<Devices> getActiveDevices(RouterDetails router) {
		Optional<Routers> getRouter = routerRepository.findbyserialNumber(router.getSerialNumber());
		List<Devices> activeDevices = new ArrayList<Devices>(); 
		if(getRouter.isPresent()){
			Routers routerPresent = getRouter.get();
			List<Devices> existingDevices = routerPresent.getDevices();
			
			for(int i=0;i<existingDevices.size();i++) {
				if(existingDevices.get(i).getIsBlocked()==false) {
					activeDevices.add(existingDevices.get(i));
				}	
			}
		}
		// TODO Auto-generated method stub
		return activeDevices;
	}


	public List<Devices> getblockedlistdevices(RouterDetails router) {
		Optional<Routers> getRouter = routerRepository.findbyserialNumber(router.getSerialNumber());
		List<Devices> blockedDevices = new ArrayList<Devices>(); 
		if(getRouter.isPresent()) {
			Routers routerPresent = getRouter.get();
			List<Devices> existingDevices = routerPresent.getDevices();
			
			for(int i=0;i<existingDevices.size();i++) {
				if(existingDevices.get(i).getIsBlocked()==true) {
//					Devices adddevice=new Devices();
//					adddevice.setDeviceId(existingDevices.get(i).getDeviceType());
//					adddevice.setDeviceType(existingDevices.get(i).getDeviceType());
					blockedDevices.add(existingDevices.get(i));
				}	
			}
		}
		// TODO Auto-generated  method stub
		return blockedDevices;
	}


	

	
	@Transactional
	public ResponseEntity<String> blockDevice(RouterDetails router) {
		Optional<Routers>  ifexists=routerRepository.findbyserialNumber(router.getSerialNumber());
		if(ifexists.isPresent()) {
			Routers existing = ifexists.get();
			System.out.println(existing.getSsid());
			//Optional<Devices> deviceget = deviceRepository.findbydeviceId(router.getDeviceId());
			for(int i=0;i<existing.getDevices().size();i++) {
				System.out.println(existing.getDevices().get(i).getDeviceId());
				System.out.println(router.getDeviceId());
				if(existing.getDevices().get(i).getDeviceId().equals(router.getDeviceId())) {
					Devices blocked = existing.getDevices().get(i);
					System.out.println(blocked.getMac());
					blocked.setIsBlocked(true);
					//routerRepository.save(existing);
					deviceRepository.save(blocked);
					return (ResponseEntity<String>) ResponseEntity.ok("Device has been blocked"); 				

				}
			}

		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Transactional
	public ResponseEntity<String> unblockDevice(RouterDetails router) {
		// TODO Auto-generated method stub
		Optional<Routers>  ifexists=routerRepository.findbyserialNumber(router.getSerialNumber());
		if(ifexists.isPresent()) {
			Routers existing = ifexists.get();
			System.out.println(existing.getSsid());
			
			List<Devices> routerDevices= existing.getDevices();
			int size;
			int activesize=0;
			if(routerDevices.isEmpty()) {
				size=1;
			}else {
				//size = routerDevices.size();
				size = routerDevices.size();
				System.out.println(size + "size");
				size+=1;
				System.out.println(size + "size");
				activesize = getActive(routerDevices);
				//activesize+=1;
				System.out.println(activesize);		
				
			}
			
			//Optional<Devices> deviceget = deviceRepository.findbydeviceId(router.getDeviceId());
			for(int i=0;i<existing.getDevices().size();i++) {
				System.out.println(existing.getDevices().get(i).getDeviceId());
				System.out.println(router.getDeviceId());
				if(existing.getDevices().get(i).getDeviceId().equals(router.getDeviceId())) {
					
					if(activesize>=10) {
						System.out.println("hello ");

						System.out.println("10 active devices already exist ");
					}
					else {
						Devices unblocked = existing.getDevices().get(i);
						System.out.println(unblocked.getMac());
						unblocked.setIsBlocked(false);
						//routerRepository.save(existing);
						deviceRepository.save(unblocked);
						return (ResponseEntity<String>) ResponseEntity.ok("Device has been unblocked"); 
					}
					
									

				}
			}

		}
		
		
		return null;
	}
	
	
	
	public int getActive(List <Devices> routerDevices){
		
		int device=0;
		for(int i=0;i<routerDevices.size();i++) {
			if(routerDevices.get(i).getIsBlocked()==false) {
				System.out.println();
				device++;
			}	
		}
		
		
		// TODO Auto-generated method stub
		return device;
	}

	@Transactional
	public ResponseEntity<String> deleteDevice(RouterDetails router) {
		// TODO Auto-generated method stub
		Optional<Routers>  ifexists=routerRepository.findbyserialNumber(router.getSerialNumber());
		if(ifexists.isPresent()) {
			Routers existing = ifexists.get();
			System.out.println(existing.getSsid());
			//Optional<Devices> deviceget = deviceRepository.findbydeviceId(router.getDeviceId());
			for(int i=0;i<existing.getDevices().size();i++) {
				System.out.println(existing.getDevices().get(i).getDeviceId());
				System.out.println(router.getDeviceId());
				List<Devices> routerDevices = existing.getDevices();  
				if(existing.getDevices().get(i).getDeviceId().equals(router.getDeviceId())) {
					//Devices deletenow = existing.getDevices().get(i);
					
					Long connectid = existing.getDevices().get(i).getConnectedDevice();
					//existing.getDevices().get(i).setRouter(null);
					routerDevices.remove(i);
					//deviceRepository.deleteById(connectid);
					existing.setDevices(routerDevices);
					System.out.println(routerDevices.size());
					deviceRepository.deleteById(connectid);
					for(int j =0;j<existing.getDevices().size();j++) {
						int sizeee = j+1;
						existing.getDevices().get(j).setDeviceId(String.valueOf(sizeee));
//						System.out.println(j + "value oj j");
//						System.out.println(existing.getDevices().get(j).getMac());
//						System.out.println(existing.getDevices().get(j).getDeviceId());	
					}
					routerRepository.save(existing);
					return (ResponseEntity<String>) ResponseEntity.ok("Device has been deleted"); 				

				}
			}
			

		}
		
		return null;
	}
	
	
	///////////////////////////below methods are all for bill payment////////////////////////////////

	public ResponseEntity<?> paybillDetails(Plans plannow) {
		System.out.println("hello by pay plan");
		//			return (ResponseEntity<String>) ResponseEntity.ok("account number does not exist");
		Optional<Plans> planexists = planRepository.findById(plannow.getPlanID());
		BillPayment bill = new BillPayment();
		if(planexists.isPresent()) {
			Plans existing = planexists.get();
			Long final_amount = 0l;
			//Long days = Duration.between(existing.getBills().getPaymentDate().atStartOfDay(),LocalDate.now().atStartOfDay()).toDays();
			System.out.println(existing.getBills().getDueDate());
			Long comparator = Duration.between(existing.getBills().getPaymentDate().atStartOfDay(), existing.getBills().getDueDate().atStartOfDay()).toDays();
			Long days = Duration.between(existing.getBills().getPaymentDate().atStartOfDay(),LocalDate.now().atStartOfDay()).toDays();
			
			
			
			if(existing.getBills().getPaymentDate().equals(LocalDate.now())) {
				System.out.println(existing.getBills().getPaymentDate() + "heloooooooo");
//				System.out.println(days);
				bill.setBillStatus("Bill was paid today");
						
				return (ResponseEntity<?>) ResponseEntity.ok(bill);
			}
			
			System.out.println(existing.getBills().getPaymentDate() + "heloooooooo");
			System.out.println(LocalDate.now());
			System.out.println(days + "days remaining");
			System.out.println(comparator + "time period");
			
			//continue editing for day comparion and set data without forgetting
			////////////////////////////////////////////////////////////////////
			if(days< (comparator-4)) {
				bill.setBillStatus("You have to wait for minimum 25 days to pay bill");
				return (ResponseEntity<?>) ResponseEntity.ok(bill);

			}
			
			if(days>(comparator+4)) {
				days= comparator+4 ;
				final_amount+=100 ;
			}
			//BigDecimal bill = new BigDecimal(days);
			BigDecimal amount = new BigDecimal(existing.getPrice());
			final int month_days = 30;
			System.out.println(amount);
			BigDecimal usage_percent = amount.divide(BigDecimal.valueOf(month_days),2,RoundingMode.HALF_EVEN);
			System.out.println(usage_percent);
					
			BigDecimal payment = usage_percent.multiply(BigDecimal.valueOf(days)).setScale(0,RoundingMode.DOWN);
			System.out.println(payment);
			
			String data_limit = existing.getDataLimit().substring(0,existing.getDataLimit().length()-2);
			String data_used = existing.getDataUsed().substring(0, existing.getDataUsed().length()-2);
			BigDecimal datalimitbig = new BigDecimal(data_limit);
			BigDecimal datausedbig = new BigDecimal(data_used);
			final_amount = final_amount + payment.longValue();
			BigDecimal dataleft = datalimitbig.subtract(datausedbig);
			if(dataleft.compareTo(BigDecimal.ZERO)<0) {
				final_amount = final_amount +(dataleft.longValue() * -1);
				System.out.println(final_amount);
			}
			
			/////above part is for bill calculation///////////
			///////editing the below part for cycle detection////////////
			
			
//			LocalDate paymentDate = LocalDate.now();
//			int count = 0;
//			int DOM = paymentDate.getDayOfMonth(); //This variable is day in that month  to use to for loop
//			System.out.println(DOM);
//			if(DOM == 1  || DOM == 11  ||DOM == 21 ) {
////				existing.setServiceTrue(true);
////				existing.getBills().setPaymentDate(LocalDate.now());
////				existing.getBills().setDueDate(LocalDate.now().plusDays(30));
////				existing.setDataUsed("0GB");
//				
//				bill.setPlanID(plannow.getPlanID());
//				bill.setPlanName(plannow.getPlanName());
//				bill.setPaymentDate(plannow.getBills().getPaymentDate());
//				bill.setCycleStartDate(paymentDate);
//				bill.setDueDate(plannow.getBills().getDueDate());
//				bill.setAmount(final_amount);
//				bill.setCustomerName(existing.getCustomer().getName());
//				bill.setBillStatus("pay bill");
//
//				
//			}else {
//				for(int i=0;i<10;i++) {
//					paymentDate = paymentDate.plusDays(1);
//					count++;
//					DOM = paymentDate.getDayOfMonth();
//					if(DOM == 1 || DOM ==11 || DOM ==21) {
////						existing.setServiceTrue(true);
////						existing.getBills().setPaymentDate(paymentDate);
////						existing.getBills().setDueDate(paymentDate.plusDays(30));
////						existing.setDataUsed("0GB");
//						bill.setPlanID(plannow.getPlanID());
//						bill.setPlanName(plannow.getPlanName());
//						bill.setCycleStartDate(paymentDate);
//						bill.setPaymentDate(plannow.getBills().getPaymentDate());
//						bill.setDueDate(plannow.getBills().getDueDate());
//						bill.setAmount(final_amount);
//						bill.setCustomerName(existing.getCustomer().getName());
//						bill.setBillStatus("pay bill");
//
//						
//						break;
//					}
//					
//				}
//				
//			}
			
			bill.setPlanID(plannow.getPlanID());
			bill.setPlanName(plannow.getPlanName());
			bill.setPaymentDate(plannow.getBills().getPaymentDate());
			bill.setDueDate(plannow.getBills().getDueDate());
			bill.setAmount(final_amount);
			bill.setCustomerName(existing.getCustomer().getName());
			bill.setBillStatus("pay bill");

			
			return (ResponseEntity<?>) ResponseEntity.ok(bill);

		}
		
		return null;
	}
	
	
	//below method is used to update the database when the user has paid his bills
	@Transactional
	public  ResponseEntity<String> paybill(BillPayment bill) {
		// TODO Auto-generated method stub
		Optional<Plans> ifexists = planRepository.findById(bill.getPlanID());
		if(ifexists.isPresent()) {
			System.out.println("hello plans");
			Plans existing = ifexists.get();
			existing.setServiceTrue(true);
			System.out.println(bill.getNo_months());
			existing.getBills().setPaymentDate(LocalDate.now());
			existing.getBills().setDueDate(LocalDate.now().plusMonths(bill.getNo_months()));

			if(bill.getNo_months()==1) {
				String data_limit = existing.getDataLimit().substring(0,existing.getDataLimit().length()-2);
				Integer dataLimitInt=Integer.parseInt(data_limit);
				dataLimitInt *= 1;
				data_limit = dataLimitInt + "GB";
				existing.setDataLimit(data_limit);

			}else if(bill.getNo_months()==3){
				
				String data_limit = existing.getDataLimit().substring(0,existing.getDataLimit().length()-2);
				Integer dataLimitInt=Integer.parseInt(data_limit);
				dataLimitInt *= 3;
				data_limit = dataLimitInt + "GB";
				existing.setDataLimit(data_limit);
				
			}else if(bill.getNo_months()==6) {
				
				String data_limit = existing.getDataLimit().substring(0,existing.getDataLimit().length()-2);
				Integer dataLimitInt=Integer.parseInt(data_limit);
				dataLimitInt *= 6;			
				data_limit = dataLimitInt + "GB";
				existing.setDataLimit(data_limit);
			}
			else {
				System.out.println("Something is wrong");
			}
			
			existing.setDataUsed("0GB");
			
			System.out.println("message is being sent");
			
			///Has been commented to send messages.
			
			
			//billPaymentMessageGenerator(existing,bill.getAmount(),bill.getPaymentDate(),bill.getDueDate());
			
			paymentHistory add_history = new paymentHistory();
			
			List<paymentHistory> paymentvelu = new ArrayList();
			
			
			add_history.setFinal_amount(bill.getAmount());
			//Dont forget to set payment type.
			add_history.setPaymentDate(bill.getPaymentDate());
			add_history.setDueDate(bill.getDueDate());
			add_history.setPlanID(bill.getPlanID());
			add_history.setPlanName(bill.getPlanName());

			add_history.setCustomerhistory(existing.getCustomer());
			
			existing.getCustomer().setPayments(paymentvelu);
			

			paymenthistory.save(add_history);
			
			planRepository.save(existing);
			
			return (ResponseEntity<String>) ResponseEntity.ok("Thank you for paying bills"); 
		}
		
		
		return null;
	}
	
	
	public void billPaymentMessageGenerator(Plans existing, Long amount, LocalDate paymentDate, LocalDate DueDate) {
		
	
		//this code below connects to twilio and generates OTP
		
		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	     Message message = Message.creator(
	       new com.twilio.type.PhoneNumber(existing.getCustomer().getphonenumber()),
	       new com.twilio.type.PhoneNumber("+14846051673"),
	       "Thank you for paying "+ amount +" on " +paymentDate.toString() + " Your next Due Date is" + DueDate.toString())
	     .create();
	     
	     
	     System.out.println("message sent");
	     System.out.println(message.getSid());		
		

	}


	
	
	
	///////////////////////////////////GET payment history part/////////////////////////////////
	
	public  List<paymentHistory> getPaymentHistory(Customers cust) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		System.out.println(cust.getEmail());
		List<paymentHistory> his = new ArrayList();
		Optional<Customers> ifexists = customerRepository.findCustomerByEmail(cust.getEmail());
		Optional<Customers> ifexistsphone = customerRepository.findCustomerByPhone(cust.getEmail());
		if(ifexists.isPresent()) {
			Customers existing = ifexists.get();
			System.out.println(existing.getName());
			System.out.println(existing.getCustomer_num());
			his = existing.getPayments();
		}
		else if(ifexistsphone.isPresent()) {
			Customers existing = ifexistsphone.get();
			System.out.println(existing.getName());
			System.out.println(existing.getCustomer_num());
			System.out.println("hello");
			his = existing.getPayments();	
		}
		
		
		return his;
	}
	
	
	
	
	
}
	

