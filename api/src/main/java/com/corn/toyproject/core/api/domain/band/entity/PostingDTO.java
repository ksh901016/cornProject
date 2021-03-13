package com.corn.toyproject.core.api.domain.band.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PostingDTO {
    private List<String> bandKeyList;
    private String content;
}
