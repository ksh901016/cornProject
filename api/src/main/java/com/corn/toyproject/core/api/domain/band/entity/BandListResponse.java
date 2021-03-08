package com.corn.toyproject.core.api.domain.band.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BandListResponse {
    @JsonProperty("bands")
    private List<Band> bandList;

    @Getter
    @Setter
    @ToString
    public static class Band {
        private String name;
        @JsonProperty("band_key")
        private String bandKey;
    }
}
