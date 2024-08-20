package com.example.lambdaTest.domain;

import io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueue;

import java.util.Map;

public interface SmslinkAPIClient {
    Map<String,String> sendTelAuthCodeRequest(String telNum);

    Map<String, String> ExecTelAuthRequest(Map<String, String> param);
}
