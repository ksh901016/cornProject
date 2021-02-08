package com.corn.toyproject.core.app.auth.domain;

import com.corn.toyproject.core.app.auth.enums.UserRole;
import com.corn.toyproject.core.common.domain.CommonDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class User extends CommonDomain {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
