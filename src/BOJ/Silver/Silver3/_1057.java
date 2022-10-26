package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 토너먼트
public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        // 참가자의 수
        int n = Integer.parseInt(stk.nextToken());
        // 김지민의 번호
        int a = Integer.parseInt(stk.nextToken());
        // 임한수의 번호
        int b = Integer.parseInt(stk.nextToken());

        // 지민이와 한수가 대결하는 라운드 번호 출력하기
        // 대결하지 않을 때는 -1을 출력한다.

        // 1 2 3 4 5 6 7 8 9 10
        // (1 2) (3 4) (5 6) (7 8) (9 10)
        // 2(1번) 4(2번) 5(3번) 8(4번) 10(5번)
        // 4(1번) 8(2번) 10(3번)

        // 2 -> 1, 4-> 2, 5 -> 3, 8 -> 4, 10 -> 5
        // 2 -> 1, 4 -> 2, 5 -> 3

        // (원래 번호 + 1) / 2의 값이 다음 순서가 된다.

        // 두 사람의 번호가 같아질 때 만나게 되는 것.
        int answer = 0;
        while(a != b) {
            a = (a+1) / 2;
            b = (b+1) / 2;
            answer++;
        }
        if (answer == 0){
            answer = -1;
        }

        buf2.write(answer + "");


        buf2.flush();
        buf.close();
        buf2.close();
    }
}