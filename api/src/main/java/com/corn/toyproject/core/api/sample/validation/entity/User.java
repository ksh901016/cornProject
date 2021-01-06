package com.corn.toyproject.core.api.sample.validation.entity;

import com.corn.toyproject.core.api.sample.validation.UserGroups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Length(max = 65)
    @NotBlank(message = "이름은 필수 입니다.")
    private String name;
    @PositiveOrZero(message = "나이는 0 이상이어야 합니다.")
    @Min(value = 25, message = "관리자는 나이가 25세 이상이어야 합니다.", groups = UserGroups.Admin.class)
    private int age;

    @NotBlank(message = "관리자는 관리자 번호가 있어야 합니다.", groups = UserGroups.Admin.class)
    private String adminNumber;
}
