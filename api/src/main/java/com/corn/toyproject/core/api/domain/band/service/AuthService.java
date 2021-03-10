package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.AccessTokenResponse;
import com.corn.toyproject.core.api.domain.band.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthApiService authApiService;

    public String getAuthUrl() throws UnsupportedEncodingException {
        return authApiService.makeAuthorizationCodeUrl();
    }

    public AccessTokenResponse getAccessToken(String code){
        AccessTokenResponse tokenResponse = authApiService.getAccessTokenInfo(code);
        TokenRepository.accessTokenResponse = tokenResponse;
        return tokenResponse;
    }
}
