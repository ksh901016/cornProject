package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.BandCommonResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandPostingRequest;
import com.corn.toyproject.core.api.domain.band.entity.BandUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BandApiService {
    @Value("${band.api.domain}")
    private String bandDomain;
    private static final String ACCESS_TOKEN = "ZQAAAbgWBx6IJZzNeCP7MizD4UvVNwH94pTYuWcY7tmFn9UFbwaRFx5u6V6qkOZjuGLv19v7QzgKt3EPwcpqlEqO0hC-TkJN4IBmopxb5Z5Jm0hT";
    private final RestTemplate restTemplate;

    private static final String BAND_LIST_URI = "/v2.1/bands";
    private static final String BAND_POSTING_URI = "/v2.2/band/post/create";
    private static final String BAND_PERMISSIONS = "/v2/band/permissions";
    private static final String BAND_USER_INFO_URI = "/v2/profile";

    public BandCommonResponse getBandList(String accessToken){
        String queryParams = String.format("?access_token=%s", accessToken);
        return callApi(BAND_LIST_URI.concat(queryParams), HttpMethod.GET, null);
    }

    public void getPermissions(String accessToken, String bandKey){
        String queryParams = String.format("?access_token=%s&band_key=%s&permissions=posting", accessToken, bandKey);
        callApi(BAND_PERMISSIONS.concat(queryParams), HttpMethod.GET, null);
    }

    public BandCommonResponse getBandUser(String accessToken){
        return callApi(BAND_USER_INFO_URI.concat("?access_token=").concat(accessToken), HttpMethod.GET, null);
    }

    public void post(BandPostingRequest postingRequest){
        // result 값 얻기
        callApi(BAND_POSTING_URI, HttpMethod.POST, postingRequest.makeMultiValueMap());
    }


    private BandCommonResponse callApi(String url, HttpMethod httpMethod, Object requestBody){
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity;
        if(HttpMethod.POST.equals(httpMethod)){
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            httpEntity = new HttpEntity(requestBody, httpHeaders);
        }else{
            httpEntity = new HttpEntity(httpHeaders);
        }

        return restTemplate.exchange(bandDomain.concat(url), httpMethod, httpEntity, BandCommonResponse.class).getBody();
    }
}
