package com.corn.toyproject.core.api.domain.band.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
@ToString
public class BandPostingRequest {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("band_key")
    private String bandKey;
    private String content;
    @JsonProperty("do_push")
    private boolean doPush = true;

    // Json 형식은 오류가남, FORM 형식으로 전달 필요
    public MultiValueMap<String, String> makeMultiValueMap(){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("access_token",this.accessToken);
        params.add("band_key", this.bandKey);
        params.add("content", this.content);
        params.add("do_push", "true");
        return params;
    }
}
