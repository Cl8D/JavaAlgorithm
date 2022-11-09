package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 주몽
public class _1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 재료의 개수
        int n = Integer.parseInt(buf.readLine());
        // 갑옷을 만드는데 필요한 수
        // 갑옷은 두 재료의 고유 번호를 합쳐서 만든다.
        int m = Integer.parseInt(buf.readLine());

        stk = new StringTokenizer(buf.readLine());
        // 재료의 고유 번호
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // 1 2 3 4 5 7
        Arrays.sort(val);
        int start = 0, end = n-1;
        int answer = 0;
        while(start < end) {
            int sum = val[start] + val[end];

            if (sum == m) {
                answer++;
                start++;
            }

            else if (sum < m) {
                start++;
            }

            else {
                end--;
            }

        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}