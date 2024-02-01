package com.ohgiraffers.chap04.secton01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // delim를 정의하지 않아도 자동으로 띄어쓰기를 구분자로 문자열을 나눠줌.

        int N = Integer.valueOf(st.nextToken());            // 동전의 종류
        int K = Integer.valueOf(st.nextToken());            // 계산할 금액(가치의 합)

        int[] coin = new int[N];                            // 동전의 종류를 담을 배열

        for (int i = 0; i < N; i++) {                       // 반복문을 돌려 동전의 종류를 담음
            coin[i] = Integer.valueOf(br.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {                  // 큰 금액의 동전부터 처리 될 수 있게 반복문 작성
            if(coin[i] <= K) {
                count += (K / coin[i]);

                /* 설명. K에서 coin[i]번째를 처리하고 남는 나머지 금액 */
                K = K % coin[i];
            }
        }

        return count;
    }
}
