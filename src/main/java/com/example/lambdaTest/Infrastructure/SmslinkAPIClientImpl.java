package com.example.lambdaTest.Infrastructure;

import com.example.lambdaTest.domain.SmslinkAPIClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmslinkAPIClientImpl implements SmslinkAPIClient {

    private RestClient client;

    public SmslinkAPIClientImpl(){
        this.client = RestClient.create();
    }

    @Override
    public Map<String, String> ExecTelAuthRequest(Map<String, String> param) {
        String result = client.get()
                .uri("hoge")
                .retrieve()
                .body(String.class);

        Map<String, String> tmpResult = new HashMap<String, String>();
        tmpResult.put("exec_key","exec_result");
        return tmpResult;
    }

    @Override
    public Map<String, String> sendTelAuthCodeRequest(String telNum) {
        Map<String, String> tmpResult = new HashMap<String, String>();
        tmpResult.put("telNumKey", telNum + "value");
        return tmpResult;
    }
}
