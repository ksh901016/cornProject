package com.corn.toyproject.core.api.sample.validation.entity;

import com.corn.toyproject.core.api.sample.validation.UserGroups;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.List;

@Builder
@Getter
public class Investment {
    @NotBlank(message = "상품번호는 필수 입니다.")
    private String productNo;
    @NotNull(message = "투자자가 있어야 합니다.")
    @Valid
    private User investor;

    @NotEmpty(message = "운영자는 한명 이상이어야 합니다.")
    private List<
            @NotNull(message = "운영자는 null 이 아니여야 합니다.")
            @ConvertGroup(to = UserGroups.Admin.class)
            @Valid User> operatorList;
}
