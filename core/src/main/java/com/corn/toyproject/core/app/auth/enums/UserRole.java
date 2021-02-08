package com.corn.toyproject.core.app.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    USER("일반 사용자"), ADMIN("관리자");
    private String text;
}
