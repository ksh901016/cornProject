package com.corn.toyproject.core.api.domain.band.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@Slf4j
@SpringBootTest
public class AuthApiServiceTest {
    @Autowired
    private AuthApiService apiService;

    @DisplayName("Authorization code URL 확인")
    @Test
    void authorizationUrlTest() throws UnsupportedEncodingException {
        String result = apiService.makeAuthorizationCodeUrl();
        Assert.assertEquals("https://auth.band.us/oauth2/authorize?response_type=code&client_id=325014160&redirect_uri=http%3A%2F%2Flocalhost%2Fband%2Ftoken", result);
    }

    @DisplayName("Authorization Code로 AccessToken 얻기 ")
    @Test
    void getTokenInfo(){
        apiService.getAccessTokenInfo(null);
    }
}
