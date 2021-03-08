package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.BandCommonResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandListResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandPostingRequest;
import com.corn.toyproject.core.common.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BandApiServiceTest {
    @Autowired
    private BandApiService apiService;
    private static final String ACCESS_TOKEN = "ZQAAAbgWBx6IJZzNeCP7MizD4UvVNwH94pTYuWcY7tmFn9UFbwaRFx5u6V6qkOZjuGLv19v7QzgKt3EPwcpqlEqO0hC-TkJN4IBmopxb5Z5Jm0hT";
    // 성현이 테스트방
    private String bandKey = "AACUst4881dIqWly4RvDWAKj";

    @DisplayName("Band 목록을 조회한다.")
    @Test
    void getBandList(){
        final BandCommonResponse bandList = apiService.getBandList(ACCESS_TOKEN);
        log.info("result : {}", bandList);
        log.info("bandList : {}", JacksonUtils.toObject(bandList.getResultData(), BandListResponse.class));
    }

    @DisplayName("특정 Band 에 글을 쓴다.")
    @Test
    void post() throws InterruptedException {
        for(int i=0; i<5; i++) {
            BandPostingRequest bandPostingRequest = new BandPostingRequest();
            bandPostingRequest.setAccessToken(ACCESS_TOKEN);
            bandPostingRequest.setBandKey(bandKey);
            bandPostingRequest.setContent("Hello"+i);
            apiService.post(bandPostingRequest);
            Thread.sleep(10000);
        }
    }

    @DisplayName("쓰기권한이 있는지 조회")
    @Test
    void getPermissions(){
        apiService.getPermissions(ACCESS_TOKEN, bandKey);
    }
}
