package com.corn.toyproject.core.api.lotto.service;

import com.corn.toyproject.core.api.lotto.entity.LottoNumber;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LottoService {
    public List<LottoNumber> getLottoNumberList(int count){
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for(int i=0; i<count; i++){
            lottoNumberList.add(makeLottoNumbers());
        }
        return lottoNumberList;
    }

    public LottoNumber makeLottoNumbers(){
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.add(pick());

        for(int i=0; i<5; i++){
            int num = pick();
            while(lottoNumber.contains(num)){
                num = pick();
            }
            lottoNumber.add(num);
        }
        lottoNumber.sort();

        return lottoNumber;
    }

    public int pick(){
        double randomValue = Math.random();
        return (int)(randomValue * 45) + 1;
    }
}
