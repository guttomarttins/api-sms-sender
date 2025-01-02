package dev.cm.apismssender.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import dev.cm.apismssender.config.TwilioConfig;
import dev.cm.apismssender.dto.SmsRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("twilio")
public class TwilioSmsSenderService implements ISmsSender{

    public final TwilioConfig twilioConfig;

    public TwilioSmsSenderService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) throws IllegalAccessException {
        if(!isValid(smsRequest)) throw new IllegalAccessException("Preencha corretamente todos os campos e tente novamente!");
        String from  = "De: " + smsRequest.sender() + "\n";
        Message message = Message
                .creator(
                   new PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
                   new PhoneNumber(twilioConfig.getTrialNumber()),
                   from + smsRequest.message()
        ).create();
    }

    public boolean isValid(SmsRequest obj){
        if(Objects.isNull(obj)) return false;
        if(obj.ddd() == 0) return false;
        if(StringUtils.isBlank(obj.sender())) return false;
        if(StringUtils.isBlank(obj.message())) return false;
        return true;
    }
}
