package com.corn.toyproject.core.api.domain.band.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthApiService authApiService;

    public String getAuthUrl() throws UnsupportedEncodingException {
        return authApiService.makeAuthorizationCodeUrl();
    }
}
