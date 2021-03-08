package com.corn.toyproject.core.api.domain.band.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BandCommonResponse {
    @JsonProperty("result_code")
    private Integer resultCode;
    @JsonProperty("result_data")
    private Object resultData;
}
