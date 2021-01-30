package com.corn.toyproject.core.api.lotto.service;

import com.corn.toyproject.core.api.lotto.entity.LottoMachine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LottoServiceTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    void pickBallTest(){
        log.debug("result : {}", lottoMachine.pickBall(6));
    }


}
