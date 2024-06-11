package com.example.major.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.major.dto.BillPayment;
import com.example.major.dto.RouterDetails;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.entity.paymentHistory;
import com.example.major.entity.users;
import com.example.major.service.CustomerService;

@RestController
@RequestMapping(path = "api/v1/")
@CrossOrigin
public class CustomerController {
	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//you inserted this line to avoid cross origins error(cors error not in the video).
	

	@GetMapping(value = "customergetall")
	public List<Customers> getCustomers(){
		 return customerService.getall();
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "customers")
	public ResponseEntity<?> Signup(@RequestBody Customers customer){
		System.out.println(customer.getAccountNumber());
		return (ResponseEntity<String>) customerService.CustomerValidation(customer);
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "signup1")
	public Customers getPhoneEmail(@RequestBody Customers customer)
	{

		return customerService.getphoneEmail(customer);
	}
	
	
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "getplans")
	public List<Plans> getPlans(@RequestBody Customers customer)
	{
		return customerService.getplans(customer);

	}
	
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "getrouter")
	public Object getRouter(@RequestBody Customers customers) {
		System.out.println("hello by routers");
		return customerService.getRouterDetails(customers);
		
	}
	
	
//	@PutMapping(path = "update/{serialNumber}")	
//	private void updateRouter(@PathVariable String serialNumber,@RequestBody RouterDetails router) {
//		System.out.println("hello by update");
//		customerService.updateRouterDetails(router);
//	}
	
	
	@PostMapping(value = "updateRouter")
	public String updateRouter(@RequestBody RouterDetails router) {
		System.out.println("hello by routers");
		return customerService.updateRouterDetails(router);
		
	}
	
	
	@PostMapping(value = "getconnecteddevices")
	public List<Devices> activedevices(@RequestBody RouterDetails router){
		return (List<Devices>) customerService.getActiveDevices(router);
	}
	
	@PostMapping(value = "getblockeddevices")
	public List<Devices> blockedlistdevices(@RequestBody RouterDetails router){	
		return (List<Devices>) customerService.getblockedlistdevices(router); 		
	}

	

	
	@PostMapping(value = "blockDevice")
	public ResponseEntity<String> blockdev(@RequestBody RouterDetails router) {
		//System.out.println("hello by routers");
		
		return customerService.blockDevice(router);
		
	}
	
	
	@PostMapping(value = "unblockDevice")
	public ResponseEntity<String> unblockdev(@RequestBody RouterDetails router) {
		//System.out.println("hello by routers");
		return customerService.unblockDevice(router);
		
	}
	
	@PostMapping(value = "deleteDevice")
	public ResponseEntity<String> deleteDevice(@RequestBody RouterDetails router){
		return customerService.deleteDevice(router);
	}
	
	@PostMapping(value = "paybills")
	public ResponseEntity<?> payBillDetails(@RequestBody Plans plannow) {
		//System.out.println("hello by routers");
		
		return (ResponseEntity<?>) customerService.paybillDetails(plannow);
		
	}
	
	
	@PostMapping(value = "payamount")
	public  ResponseEntity<String> payBill(@RequestBody BillPayment bill) {
		//System.out.println("hello by routers");
		return customerService.paybill(bill);		
	}
	
	
	
	
	@PostMapping(value = "getpaymenthistory")
	public  List<paymentHistory> getPaymnetHistory(@RequestBody Customers cust) {
		//System.out.println("hello by routers");
		System.out.println(cust.getEmail());
		return customerService.getPaymentHistory(cust);		
	}
	

	
	
	
}
