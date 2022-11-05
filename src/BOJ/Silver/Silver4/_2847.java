package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 게임을 만든 동준이
public class _2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[n];

        // 레벨 = 난이도 순
        // 쉬운 레벨이 어려운 레벨보다 점수를 많이 받음
        // -> 그래서 특정 레벨의 값을 감소시켜 오름차순으로 증가하도록 하는 것.
        // 항상 점수는 양수, 점수를 최소한으로 내리는 방법 찾기
        int answer = 0;

        for (int i = 0; i < n; i++) {
            // 각 레벨을 클리어하면 얻는 점수
            val[i] = Integer.parseInt(buf.readLine());
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = n-2; i >= 0; i--) {
            int nextScore = val[i+1];
            int score = val[i];

            if (score >= nextScore) {
                answer += (score - nextScore + 1);
                val[i] = nextScore - 1;
            }
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}