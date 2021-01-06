package com.corn.toyproject.core.api.sample.validation;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Builder
@Getter
public class User {
    @Length(max = 65)
    @NotBlank(message = "이름은 필수 입니다.")
    private String name;
    @PositiveOrZero(message = "나이는 0 이상이어야 합니다.")
    @Min(value = 15, message = "")
    private int age;

    private String driverLicenseNumber;
}
