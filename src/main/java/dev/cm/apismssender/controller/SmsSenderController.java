package dev.cm.apismssender.controller;

import dev.cm.apismssender.dto.SmsRequest;
import dev.cm.apismssender.service.ISmsSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsSenderController {

    private final ISmsSender smsSender;

    public SmsSenderController(@Qualifier("twilio") ISmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest smsRequest) throws IllegalAccessException {
        smsSender.sendSms(smsRequest);
    }
}