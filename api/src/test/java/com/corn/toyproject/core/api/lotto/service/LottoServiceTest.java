package com.corn.toyproject.core.api.lotto.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    void pickTest(){
        log.info("result : {}", lottoService.pick());
    }

    @Test
    void makeLottoNumbersTest(){
        log.info("result : {}", lottoService.makeLottoNumbers());
    }
}
