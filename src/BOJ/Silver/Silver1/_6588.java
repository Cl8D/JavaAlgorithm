package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 골든바흐의 추측
public class _6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 6 ~ 1000000까지의 소수 판별
        boolean[] val = new boolean[1000001];

        // 에라토스테네스의 체
        // 여기서 홀수인 소수만 false
        for (int i = 2; i <= 1000000; i++) {
            if (val[i]) {
                continue;
            }
            for (int j = 2*i; j <= 1000000; j+=i) {
                val[j] = true;
            }
        }

        while(true) {
            int v = Integer.parseInt(buf.readLine());
            if (v == 0) {
                break;
            }
            boolean flag = false;
            for (int i = 2; i <= v; i++) {
                // i + (v-i) = v
                // 둘 다 소수라면 이 수식은 성립한다.
                if(!val[i] && !val[v-i]) {
                    flag = true;
                    sb.append(v).append(" = ").append(i).append(" + ").append(v-i).append("\n");
                    break;
                }
            }
            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}