package com.example.lambdaTest.domain;

public interface SendTelAuthCodeService {
    /**
     * 電話認証用の認証コードを送信する。
     * @param telNum 送信先電話番号
     */
    void sendTelAuthCode(String telNum);
}
