package com.login360.repository;

import com.login360.entities.SmsRequest;

public interface SmsSender {
	void smsSend(SmsRequest smsRequest);

}
