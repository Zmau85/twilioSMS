package com.login360.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.login360.entities.SmsRequest;
import com.login360.repository.SmsSender;

@org.springframework.stereotype.Service
public class SmsService {
	
	private final SmsSender twilioSmsSender;

	@Autowired
	public SmsService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
		
		this.twilioSmsSender = twilioSmsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		
	}
	
	
	
	

}
