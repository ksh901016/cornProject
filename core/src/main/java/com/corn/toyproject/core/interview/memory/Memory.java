package com.corn.toyproject.core.interview.memory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Memory {
    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 2, 3, 3};
        checkDuplicates(test);
    }

    /**
     * 1부터 N 까지의 숫자가 든 배열이 있다. N은 최대 32,000이다. 이 배열에는 중복된 수가 있으며, N이 얼마인지는 모른다.
     * 메모리는 4 Kbytes로 제한되어 있다. 배열에 있는 모든 중복 원소를 출력하려면 어떻게 해야 하겠는가?
     * 4 Kbytes = 4 * 8 * 2^10 , 32,000보다 크다
     */

    public static void checkDuplicates(int[] array){
        BitSet bs = new BitSet(32000);
        for(int num : array){
            if(bs.get(num)){
                log.debug("duplication : {}", num);
            }else{
                bs.set(num);
            }
        }
    }

    static class BitSet{
        int[] bitSet;

        public BitSet(int size){
            bitSet = new int[size >> 5]; // 32로 나눈다. (32bit)
        }

        boolean get(int pos){
            int wordNumber = (pos >> 5); // 몇 번째 int 배열방에 존재하는지 (32로 나눈다.)
            log.debug("{} 번째 방", wordNumber);
            int bitNumber = pos&0x1F; // 32모듈러 연산(bitSet[wordNumber]방의 bitNumber 째 비트)
            log.debug("{} 번째 bit", bitNumber);
            return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
        }

        void set(int pos){
            int wordNumber = (pos >> 5);
            int bitNumber = pos&0x1F;
            bitSet[wordNumber] |= (1 << bitNumber);
        }
    }
}
