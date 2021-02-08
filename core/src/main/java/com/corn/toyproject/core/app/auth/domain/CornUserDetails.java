package com.corn.toyproject.core.app.auth.domain;

import com.corn.toyproject.core.common.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class CornUserDetails implements UserDetails {
    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Status.USE.equals(user.getStatus());
    }

    @Override
    public boolean isAccountNonLocked() {
        return Status.USE.equals(user.getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Status.USE.equals(user.getStatus());
    }

    @Override
    public boolean isEnabled() {
        return Status.USE.equals(user.getStatus());
    }
}
