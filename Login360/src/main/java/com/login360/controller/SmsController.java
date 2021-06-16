package com.login360.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login360.entities.SmsRequest;
import com.login360.service.SmsService;

@RestController
@RequestMapping("home/api")
public class SmsController {

	private final SmsService smsService;

	@Autowired
	public SmsController(SmsService smsService) {
		
		this.smsService = smsService;
	}
	
	@PostMapping
	public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		
		smsService.sendSms(smsRequest);
		
	}
	

}
