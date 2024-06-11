package com.example.major.controller;

//import java.util.List;



//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.major.entity.users;
import com.example.major.service.UserService;

@RestController
@RequestMapping(path = "api/v1")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class UserController {
	
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//you inserted this line to avoid cross origins error(cors error not in the video).
	
	
	@PostMapping(value = "/users")
	public ResponseEntity<String> Login(@RequestBody users User) {
		return (ResponseEntity<String>) userService.login(User);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/signup")
	public ResponseEntity<String> Signup(@RequestBody users User) {
		 System.out.println(User);
	     return (ResponseEntity<String>) userService.signup(User);
	}
	
	
//	   @PostMapping("/hook")
//	  @ResponseBody
//	  public String getTwiML() {
//
//	    return new MessagingResponse.Builder().message(
//	      new Message.Builder("Thanks for your message").build())
//	        .build()
//	        .toXml();
//	  }
	
	
	@PostMapping(value = "/otp")
	public ResponseEntity<String> OTP(@RequestBody users user){
		//System.out.println("otp checker");
		System.out.println(user);
		return (ResponseEntity<String>) userService.OtpGenerator(user);

	}
	
	
	@PostMapping(value = "/profile")
	public users getprofile(@RequestBody users User) {
		return userService.profilepage(User);	
	}
	
	
	//@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping(value="/forgotPassword")

	public ResponseEntity<String> forgotpwd(@RequestBody users User)

	{

		return userService.checkuser(User);

	}

	

	//@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping(value="/otpcheck")

	public ResponseEntity<String> Otpforpwd(@RequestBody users User)

	{

		return userService.Otpforpwd(User);

	}

	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/changepwd")
	public ResponseEntity<String> changepwd(@RequestBody users User)

	{

		return userService.changepwd(User);

	}

	
	   
	   	   
}
