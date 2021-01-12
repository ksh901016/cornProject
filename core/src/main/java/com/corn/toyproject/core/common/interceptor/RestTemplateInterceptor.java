package com.corn.toyproject.core.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private static final String[] EXCLUDE_URL = {

    };

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("Request Header : {}", request.getHeaders());
        log.info("Request Url : {}", request.getURI());
        log.info("Request Body : {}", new String(body, StandardCharsets.UTF_8));

        try {
            ClientHttpResponse response = execution.execute(request, body);
            if(isPrintLog(request.getURI().toString())){
                log.info("Response Header : {}", response.getHeaders());
                log.info("Response Body : {}", StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
            }
            return response;
        }catch (IOException e){
            throw new RuntimeException("커스터마이징 필요");
        }
    }

    private boolean isPrintLog(String uri){
        for(String url : EXCLUDE_URL){
            if(uri.contains(url)){
                return false;
            }
        }
        return true;
    }
}
