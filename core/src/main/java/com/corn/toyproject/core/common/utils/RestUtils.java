package com.corn.toyproject.core.common.utils;

import com.corn.toyproject.core.common.interceptor.RestTemplateInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Service
public class RestUtils {
    @Bean
    static RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectionRequestTimeout(5000);
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(13000);

        return RestUtils.getRestTemplate(factory);
    }

    private static RestTemplate getRestTemplate(HttpComponentsClientHttpRequestFactory factory){
        // 커넥션풀
        // todo apache HttpComponents 를 사용하지 않고 사용할 수 있는 방법 찾아보기
        HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(20).build();
        factory.setHttpClient(httpClient);

        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(factory);
        RestTemplate restTemplate = new RestTemplate(bufferingClientHttpRequestFactory);

        List<ClientHttpRequestInterceptor> interceptorList = restTemplate.getInterceptors();
        interceptorList.add(new RestTemplateInterceptor());

        restTemplate.setInterceptors(interceptorList);
        restTemplate.setErrorHandler(new CustomRestErrorHandler());
        return restTemplate;
    }

    public static class CustomRestErrorHandler implements ResponseErrorHandler{
        @Override
        public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
            return false;
        }

        @Override
        public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        }
    }
}
