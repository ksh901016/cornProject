package com.corn.toyproject.core.api.lotto.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
public class LottoNumber {
    private final List<Integer> lottoNumber = new ArrayList<>(6);

    public void add(int num){
        lottoNumber.add(num);
    }

    public boolean contains(int num){
        return lottoNumber.contains(num);
    }

    public void sort(){
        Collections.sort(lottoNumber);
    }
}
