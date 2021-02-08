package com.corn.toyproject.core.interview.memory;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 40억 개의 0을 포함하는 양의 정수가 들어있는 파일이 있다. 이 파일에 없는 정수 하나를 찾는 알고리즘을 고안하라.
 * 1GB 의 메모리를 사용할 수 있다.
 * - 메모리가 10MB 밖에 없다면? 중복된 수는 없으며, 전부 10억 개 이하라고 가정하라.
 *
 * 1GB = 대략 10억Byte = 80억 bit
 */
@Slf4j
public class SearchNotExistedNum {
    /**
     * 해결법
     * 1. 40억 개의 비트로 구성된 비트 벡터(BV)를 만든다. 비트 벡터는 int의 배열을 사용해 불린 값을 압축적으로 보관하는 배열 (int는 32비트, 32개의 불린 값 표현) - 10억개의 int 배열 필요
     * 2. BV를 0으로 초기화
     * 3. 파일에서 모든 수를 읽어 BV.set(num, 1)을 실행
     * 4. BF를 0번 첨자 위치부터 순서대로 읽음
     * 5. 0이 아닌 값을 갖는 첫 번째 첨자를 반환
     */
    long numberOfInts = ((long)Integer.MAX_VALUE) + 1;
    byte[] bitfield = new byte[(int)numberOfInts/8];

    public static void main(String[] args) {
        SearchNotExistedNum searchNotExistedNum = new SearchNotExistedNum();
    }

    void findNotExistNumber() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("file.txt"));
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            /**
             * bitfield 배열의 바이트 하나를 찾아 OR 연산자를 사용하여
             * 특정한 비트 하나를 1로 만든다.
             * ex) 10은 bitfield의 2번째 바이트의 두번째 비트에 해당한다.
             */
            bitfield[n/8] |= 1 << (n % 8);
        }

        for(int i=0; i<bitfield.length; i++){
            for(int j=0; j<8; j++){
                if((bitfield[i] & (1 << j)) == 0){
                    /**
                     * 각 바이트의 개별 비트 값을 읽는다.
                     * 0인 비트를 발견하면 거기 해당하는 값을 찾는다.
                     */
                    log.debug("{}", i*8+j);
                    return;
                }
            }
        }
    }

    /**
     * 메모리가 10MB 밖에 없다면?
     *
     */

}
