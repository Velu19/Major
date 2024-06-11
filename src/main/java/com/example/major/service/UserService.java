package com.example.major.service;

import java.text.DecimalFormat;


import java.util.List;



import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.major.entity.users;
import com.example.major.repository.UserRepository;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.transaction.Transactional;


@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
//	public Optional<users> getUsers(){
//		return userRepository.findStudentLogin("guru@gmail.com", "hello");
//	}

	

	public ResponseEntity<String> login(users user) {
		//System.out.println(user);
		Optional<users> current = userRepository.findStudentByEmail(user.getEmail());
		Optional<users> current1 = userRepository.findStudentByPhone(user.getEmail());
		if(current.isPresent()) {
			
			users check = current.get();
			System.out.println(check);
			if(check.getPassword().equals(user.getPassword())) {
				return (ResponseEntity<String>) ResponseEntity.ok("Login succesfull");
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("password does not match");
			}
			
		}else if(current1.isPresent()){
			users check = current1.get();
			System.out.println(check);
			if(check.getPassword().equals(user.getPassword())) {
				return (ResponseEntity<String>) ResponseEntity.ok("Login succesfull");
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("password does not match");
			}
		}else {
			return (ResponseEntity<String>) ResponseEntity.ok("phone/email does not exist");
		}
		
		// TODO Auto-generated method stub
		
	}

	public ResponseEntity<String> signup(users user) {
		// TODO Auto-generated method stub
		//complete signup logic today.
		//System.out.println(user);
		
		userRepository.save(user);
		//OtpGenerator(user);
		return (ResponseEntity<String>) ResponseEntity.ok("Object Created");

	}
	
	
	
	
	

	public ResponseEntity<String> OtpGenerator(users user) {
		
		Optional<users> Email_check = userRepository.findStudentByEmail(user.getEmail()); //checks if email is already registered.
		Optional<users> Phone_check = userRepository.findStudentByPhone(user.getPhonenumber()); //checks if phone number is already registered.
		System.out.println(user);
		//System.out.println(Email_check );
		//System.out.println(Phone_check );
		if(Email_check.isPresent()) {
			return (ResponseEntity<String>) ResponseEntity.ok("Email already exist");
		}else if(Phone_check.isPresent()) {
			return (ResponseEntity<String>) ResponseEntity.ok("Phone number already exists");
		}
		else if(user.getPhonenumber().length()!=13) {
			return (ResponseEntity<String>) ResponseEntity.ok("Phone number should be of 13 digits including +91");
		}
		
		System.out.println("otp service checker");
		System.out.println(user);
		String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));  //we generate our very own OTP using this code
		System.out.println(otp);
		System.out.println(user.getPhonenumber());
		
		//this code below connects to twilio and generates OTP
		
		final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";
		final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";
	     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	     Message message = Message.creator(
	       new com.twilio.type.PhoneNumber(user.getPhonenumber()),
	       new com.twilio.type.PhoneNumber("+14846051673"),
	       "OTP to login: "+otp)
	     .create();

	     System.out.println(message.getSid());		


		return (ResponseEntity<String>) ResponseEntity.ok(otp);
		

	}

	public users profilepage(users user) {
		//System.out.println(user);
		Optional<users> current = userRepository.findStudentByEmail(user.getEmail());
		Optional<users> currentPhone = userRepository.findStudentByPhone(user.getEmail());
		if(current.isPresent()) {
			users exists = current.get();
			users send = new users();
			send.setEmail(exists.getEmail());
			send.setName(exists.getName());
			send.setPhonenumber(exists.getPhonenumber());
			send.setAccountNumber(exists.getAccountNumber());
			return send;
		}
		else if(currentPhone.isPresent()) {
			users exists = currentPhone.get();
			users send = new users();
			send.setEmail(exists.getEmail());
			send.setName(exists.getName());
			send.setPhonenumber(exists.getPhonenumber());
			send.setAccountNumber(exists.getAccountNumber());
			return send;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	//service

	 

	public ResponseEntity <String> checkuser(users User) {

			// TODO Auto-generated method stub

			

			Optional<users> current = userRepository.findStudentByPhone(User.getPhonenumber());

			

			if(current.isPresent())

			{

				return(ResponseEntity<String>) ResponseEntity.ok("User exists");

			}

			else

			{

				return(ResponseEntity<String>) ResponseEntity.ok("Not exists");

			}

		}

	 

	 

	public ResponseEntity<String> Otpforpwd(users user)

		{

			Optional<users> phonecheck = userRepository.findStudentByPhone(user.getPhonenumber());

			if(phonecheck.isPresent())

			{

				String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));

				

				//this code below connects to twilio and generates OTP

				System.out.println(user.getPhonenumber());

				final String ACCOUNT_SID = "AC6cff50c39280fb7c472fa837981cda2f";

				final String AUTH_TOKEN = "2a6988e73de7d6a9e37055afda24cb27";

			     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			     Message message = Message.creator(

			       new com.twilio.type.PhoneNumber(user.getPhonenumber()),

			       new com.twilio.type.PhoneNumber("+14846051673"),

			       "OTP to login: "+otp)

			     .create();

		

			     System.out.println(message.getSid());	

				

				return(ResponseEntity<String>) ResponseEntity.ok(otp);
				

			}

			else

			{

				return(ResponseEntity<String>) ResponseEntity.ok("Not exists");

			}

		}

	 

	 
	@Transactional
	public ResponseEntity<String> changepwd(users user)

		{

			users getpwd = userRepository.findStudentByPhone(user.getPhonenumber()).get();

			if(getpwd.getPassword().equals(user.getPassword()))

			{

				return(ResponseEntity<String>) ResponseEntity.ok("Same password");

			}

			else

			{

			    getpwd.setPassword(user.getPassword());

			    userRepository.save(getpwd);

			    return(ResponseEntity<String>) ResponseEntity.ok("Password changed");

			}

		}
	
}
