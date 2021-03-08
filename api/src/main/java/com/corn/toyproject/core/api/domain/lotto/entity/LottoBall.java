package com.corn.toyproject.core.api.domain.lotto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class LottoBall implements Comparable<LottoBall>{
    private int number;
    private Color color;

    LottoBall(int number) {
        this.number = number;
        this.color = Color.getColor(number);
    }

    @Override
    public int compareTo(LottoBall o) {
        return this.getNumber() - o.getNumber();
    }

    @Getter
    @AllArgsConstructor
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private enum Color{
        YELLOW(0, "#e6e600"), // 1 ~ 10번 공
        BLUE(1, "#00008B"),   // 11 ~ 20번 공
        RED(2, "#FF0000"),    // 21 ~ 30번 공
        GRAY(3, "#696969"),   // 31 ~ 40번 공
        GREEN(4, "#008000");  // 41 ~ 45번 공

        private int index;
        private String code;

        private static final Map<Integer, Color> COLOR_MAP = new HashMap<>();

        static {
            for(Color color: values()){
                COLOR_MAP.put(color.index, color);
            }
        }

        public static Color getColor(int lottoNum){
            return COLOR_MAP.get((lottoNum-1)/10);
        }
    }
}

