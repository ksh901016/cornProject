package com.corn.toyproject.core.api.domain.band.controller;

import com.corn.toyproject.core.api.common.entity.Response;
import com.corn.toyproject.core.api.common.entity.SuccessResponse;
import com.corn.toyproject.core.api.domain.band.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/api/band/auth/url")
    public Response getAuthUrl() throws UnsupportedEncodingException {
        return new SuccessResponse(authService.getAuthUrl());
    }

    @GetMapping("/api/band/auth/token/{code}")
    public Response getToken(@PathVariable String code){
        return new SuccessResponse(authService.getAccessToken(code));
    }
}

