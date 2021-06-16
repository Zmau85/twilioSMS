package com.login360.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login360.config.TwilioConfiguration;
import com.login360.entities.SmsRequest;
import com.login360.repository.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {

		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public void smsSend(SmsRequest smsRequest) {
		if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
			String message = smsRequest.getMessage();
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();

		} else {
			throw new IllegalArgumentException("Phone number is not valid");
		}

	}

	private boolean isPhoneNumberValid(String phoneNumber) {

		return true;

	}

}
