package dev.cm.apismssender.service;

import dev.cm.apismssender.dto.SmsRequest;

public interface ISmsSender {
    void sendSms(SmsRequest smsRequest) throws IllegalAccessException;
}
