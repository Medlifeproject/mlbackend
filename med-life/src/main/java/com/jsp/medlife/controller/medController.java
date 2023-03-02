package com.jsp.medlife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medlife.Model.Entities.User;
import com.jsp.medlife.servece.impl.MedServiceImpl;

@Controller
@RestController
public class medController 
{
    @Autowired
    private MedServiceImpl medser;
	
    @PostMapping("/signup")
	 ResponseEntity<Object>  saveUser(@RequestBody User ue)
	{
       Object	in= medser.saveMed(ue);
				
		if(in instanceof User)	
		{
			return ResponseEntity.status(200).body("SIGN UP SUCCESSFULL DONE");
		}
		
			return ResponseEntity.status(400).body(medser.saveMed(ue));		
	}
    
    
    
    @GetMapping("/login")
  	 ResponseEntity<Object>  login(@RequestHeader String password ,@RequestHeader String email)
  	{
         Object	oo= medser.findByLogin(email, password);
         System.out.println(email+" "+password);
  				
  		if(oo instanceof User)	
  		{
  			return ResponseEntity.status(200).body("LOGIN SUCCESSFULL DONE");
  		}
  		
  			return ResponseEntity.status(400).body(medser.findByLogin(email,password));		
  	}
	
    @GetMapping("/forgetpass")
 	 ResponseEntity<Object>  frgetpass(@RequestHeader String password ,@RequestHeader String email,@RequestHeader String confirmPass)
 	{
    	Object ll = medser.findByForgetPass(email, password, confirmPass);
    	if(ll instanceof User)
    	{
    		return ResponseEntity.status(200).body(" PASSWORD UPDATED SUCCESSFULL");
    	}
    	return ResponseEntity.status(200).body(medser.findByForgetPass(email, password, confirmPass));
 	}
    
}
