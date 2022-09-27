package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 별 찍기 - 10
public class _2447 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        sb = new StringBuilder("");

        /*
        이해하기 쉬운 블로그 설명: https://st-lab.tistory.com/95
        아이디어가 좋은 블로그: https://cryptosalamander.tistory.com/38

        ex) n=3이라고 했을 때
         ***************************
         * ** ** ** ** ** ** ** ** *
         ***************************
         -> (1,1) (1,4), (1,7)...

        *********
        * ** ** *
        *********
        ***   ***
        * *   * *
        ***   ***
        *********
        * ** ** *
        *********
        -> 가운데가 빈 모양의 경우, (3,3)(3,4)(3,5) (4,3)(4,4)(4,5) (5,3)(5,4)(5,5)이다.
        (i, j) -> (i/3) % 3 == 1, (j/3) % 3 == 1
        */

        int n = Integer.parseInt(buf.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                makeStar(i, j, n);
            }
            sb.append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void makeStar(int i, int j, int val) {
        // 여기 조건문이 진짜 중요... 공백인 조건의 일반화가 가능하다니...!
        if ((i / val) % 3 == 1 && (j / val) % 3 == 1) {
            sb.append(" ");
        }
        else {
            // 3으로 더 나누어지지 않을 때
            if (val / 3 == 0) {
                sb.append("*");
            }
            // 다음 재귀 호출 시작
            else {
                makeStar(i, j, val/3);
            }
        }
    }
}