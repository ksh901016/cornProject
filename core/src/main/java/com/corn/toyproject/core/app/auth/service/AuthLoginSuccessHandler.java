package com.corn.toyproject.core.app.auth.service;

import com.corn.toyproject.core.app.auth.domain.CornUserDetails;
import com.corn.toyproject.core.app.auth.domain.User;
import com.corn.toyproject.core.app.auth.utils.TokenUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user = ((CornUserDetails)authentication.getPrincipal()).getUser();
        String token = TokenUtils.generateJwtToken(user);
        response.addHeader(HttpHeaders.AUTHORIZATION, "BEARER ".concat(token));
    }
}
