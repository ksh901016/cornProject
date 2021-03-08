package com.corn.toyproject.core.api.domain.band.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthApiService {
    @Value("${band.auth.domain}")
    private String bandDomain;
    @Value("${local.domain}")
    private String localDomain;
    private final RestTemplate restTemplate;

    private static final String CLIENT_ID = "325014160";
    private static final String CLIENT_SECRET = "wsBTH2qH-IS1TBt2yw0LNn76AvBplyAt";

    private static final String AUTHORIZATION_URI = "/oauth2/authorize";
    private static final String TOKEN_URI = "/oauth2/token";

    private static final String CALLBACK_URI = "/band/token";


    public String makeAuthorizationCodeUrl() throws UnsupportedEncodingException {
        String encodedCallbackUrl = URLEncoder.encode(localDomain.concat(CALLBACK_URI), "UTF-8");
        return String.format(bandDomain.concat(AUTHORIZATION_URI).concat("?response_type=code&client_id=%s&redirect_uri=%s"), CLIENT_ID, encodedCallbackUrl);
    }

    public void getAccessTokenInfo(String code){
        String queryParams = String.format("?code=%s&grant_type=authorization_code", code);

        HttpHeaders headers = new HttpHeaders();
        String base64EncodedAuthInfo = new String(Base64.getEncoder().encode(CLIENT_ID.concat(":").concat(CLIENT_SECRET).getBytes()));
        headers.add(HttpHeaders.AUTHORIZATION, "Basic ".concat(base64EncodedAuthInfo));

        String url = bandDomain.concat(TOKEN_URI).concat(queryParams);
        log.info("{}", restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Map.class).getBody());
    }

}
