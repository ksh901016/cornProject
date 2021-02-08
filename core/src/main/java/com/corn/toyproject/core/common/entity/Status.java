package com.corn.toyproject.core.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    USE("사용"), STOP("정지");

    private String text;
}
