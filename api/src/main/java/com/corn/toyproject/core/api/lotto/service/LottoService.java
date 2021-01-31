package com.corn.toyproject.core.api.lotto.service;

import com.corn.toyproject.core.api.lotto.entity.LottoBall;
import com.corn.toyproject.core.api.lotto.entity.LottoMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LottoService {
    private final LottoMachine lottoMachine;

    public List<Set<LottoBall>> lottery(int count){
        List<Set<LottoBall>> lottoList = new ArrayList<>();

        for(int i=0; i<count; i++){
            lottoList.add(lottoMachine.pickBall(6));
        }
        return lottoList;
    }
}
