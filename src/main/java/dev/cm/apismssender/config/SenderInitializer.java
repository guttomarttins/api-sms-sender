package dev.cm.apismssender.config;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Slf4j
@Configuration
public class SenderInitializer {

    public static Logger logger = Logger.getLogger(SenderInitializer.class.getName());

    public SenderInitializer(TwilioConfig senderConfiguration) {
        Twilio.init(senderConfiguration.getAccountSid(), senderConfiguration.getAuthToken());
        logger.info("Twilio initialized");
    }
}
