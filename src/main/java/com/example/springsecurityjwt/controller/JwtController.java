package com.example.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurityjwt.entity.AuthRequest;
import com.example.springsecurityjwt.util.JwtUtil;

@RestController
public class JwtController {
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to JWT example API";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authReqst) {
		try {
			authManager.authenticate( new UsernamePasswordAuthenticationToken(authReqst.getUserName(),authReqst.getPassword()));
		}catch(BadCredentialsException ex) {
			throw new BadCredentialsException(ex.getMessage());
		}
		
		return jwtutil.generateToken(authReqst.getUserName());
		 
	}

}
