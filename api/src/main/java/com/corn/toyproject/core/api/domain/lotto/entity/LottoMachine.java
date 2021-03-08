package com.corn.toyproject.core.api.domain.lotto.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Service
public class LottoMachine {
    public Set<LottoBall> pickBall(int count){
        Set<LottoBall> lottoBalls = new TreeSet<>();
        for(int i=0; i<count; i++){
            addBall(lottoBalls);
        }
        return lottoBalls;
    }

    private void addBall(Set<LottoBall> lottoBalls){
        int ballNumber = getRandomNumber();
        while(isExist(lottoBalls, ballNumber)){
            ballNumber = getRandomNumber();
        }
        lottoBalls.add(new LottoBall(ballNumber));
    }
    private boolean isExist(Set<LottoBall> lottoBalls, int ballNumber){
        return lottoBalls.stream().anyMatch(lottoBall -> lottoBall.getNumber() == ballNumber);
    }

    private int getRandomNumber(){
        double randomVue = Math.random();
        return (int) ((randomVue * 45) + 1);
    }

}
