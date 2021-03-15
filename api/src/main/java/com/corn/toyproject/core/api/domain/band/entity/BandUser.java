package com.corn.toyproject.core.api.domain.band.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BandUser {
    @JsonProperty("user_key")
    private String userKey;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    private String name;
}
