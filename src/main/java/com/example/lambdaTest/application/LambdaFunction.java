package com.example.lambdaTest.application;

import com.example.lambdaTest.domain.ExecTelAuthService;
import com.example.lambdaTest.domain.SendTelAuthCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
public class LambdaFunction {

    private SendTelAuthCodeService sendTelAuthCodeService;
    private ExecTelAuthService execTelAuthService;

    @Autowired
    public LambdaFunction(SendTelAuthCodeService sendTelAuthCodeService,ExecTelAuthService execTelAuthService){
       this.sendTelAuthCodeService = sendTelAuthCodeService;
       this.execTelAuthService = execTelAuthService;
    }

    /**
     * smslinkAPIを用いて、リクエストパラメーターに含まれる電話番号宛てに認証コードをsms送信する。
     *
     * @return
     */
    @Bean
    Function<Map<String, String>, Map<String, String>> sendTelAuthCode() {
        return param -> {
            System.out.println(param);
            String telNumber = param.get("telNumber");

            sendTelAuthCodeService.sendTelAuthCode(telNumber);

            Map<String, String> response = new HashMap<>();
            response.put("type", "createCode");
            response.put("telNumber", telNumber);

            log.atInfo();
            return response;
        };
    }

    /**
     * 実認証処理
     *
     * @return
     */
    @Bean
    Function<Map<String, String>, Map<String, String>> execTelAuth() {
        return param -> {
//            String authCode = param.get("code");
            Map<String, String> response = new HashMap<>();

            // TODO: service.sendTelAuthCode();

           response.put("type","execAuth");

            log.atInfo();
            return response;
        };
    }
}
