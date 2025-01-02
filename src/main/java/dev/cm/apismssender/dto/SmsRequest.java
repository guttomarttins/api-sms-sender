package dev.cm.apismssender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public record SmsRequest(
        String sender,
        int ddd,
        String phoneNumber,
        String message) {

    public SmsRequest(@JsonProperty("sender") String sender,
                      @JsonProperty("ddd") int ddd,
                      @JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.sender = sender;
        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
