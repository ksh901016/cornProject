package com.corn.toyproject.core.api.domain.band.controller;

import com.corn.toyproject.core.api.domain.band.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/api/band/auth/url")
    public String getAuthUrl() throws UnsupportedEncodingException {
        return authService.getAuthUrl();
    }
}
