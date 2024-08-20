package com.example.lambdaTest.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendTelAuthCodeServiceImpl implements SendTelAuthCodeService {
    private SmslinkAPIClient client;

    @Autowired
    public SendTelAuthCodeServiceImpl(SmslinkAPIClient client) {
        this.client = client;
    }

    @Override
    public void sendTelAuthCode(String telNum) {
        Map<String, String> result = client.sendTelAuthCodeRequest(telNum);
    }
}
