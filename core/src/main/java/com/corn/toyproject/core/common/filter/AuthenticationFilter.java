package com.corn.toyproject.core.common.filter;

import com.corn.toyproject.core.app.auth.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequestToken;
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())){
                throw new RuntimeException("email, password is empty");
            }
            authRequestToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setDetails(request, authRequestToken);
        return this.getAuthenticationManager().authenticate(authRequestToken);
    }
}
