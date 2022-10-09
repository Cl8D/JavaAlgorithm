package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 한 줄로 서기
public class _1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n+1];

        // 입력은 키가 작은 순서대로 들어옴
        for (int i = 1; i <= n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        // 키가 큰 순서부터 차례대로 삽입
        // 왼쪽에 몇 명 있었는지 체크 = 몇 번째의 위치에 들어갈 것인지
        for (int i = n; i > 0 ; i--) {
            answer.add(val[i], i);
        }

        for(Integer ans : answer) {
            sb.append(ans).append(" ");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}