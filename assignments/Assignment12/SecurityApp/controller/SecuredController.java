package com.example.SecurityApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityApp.service.MyUserDetailService;
import com.example.SecurityApp.users.Myusers;

@RestController
public class SecuredController {
	
	@Autowired
	MyUserDetailService  myUserDetailService;
	
	@GetMapping("/publicEndPoint")
	public String forPublic() {
		return "this is the open end point for public";
	}
	
	
	@GetMapping("/securedUserEndPoint")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String forUsers() {
		return "this is the secured end point only for user";
	}
	
	@GetMapping("/securedAdminEndPoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String forAdmins() {
		return "this is the secured end point only for admin";
	}
	
//	@PostMapping("/addUser")
//	public String addUser(@RequestBody Myusers user) {
//		myUserDetailService.addUser(user);   // just delegate
//	    return "User added successfully";
//	}

}
