package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 가장 긴 바이토닉 부분 수열
public class _11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];


        // 왼쪽 -> 오른쪽으로 증가하는 수열 찾기
        for (int i = 0; i < n; i++) {
            leftMax[i] = 1;
            for (int j = 0; j < i; j++) {
                if (val[i] > val[j]) {
                    leftMax[i] = Math.max(leftMax[i], leftMax[j]+1);
                }
            }
        }

        // 왼쪽 -> 오른쪽으로 감소하는 수열 = 오른쪽 -> 왼쪽으로 증가하는 수열 찾기
        // 이때, 왼->오, 오->왼 수열을 더해줄 거니까 겹치는 부분이 존재하기 때문에 초기값을 0으로 둔다.
        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (val[i] < val[j]) {
                    rightMax[j] = Math.max(rightMax[j], rightMax[i]+1);
                }
            }
        }

        // 두 수열의 합을 더해주면 된다. (각각 최대가 될 경우니까)
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, leftMax[i] + rightMax[i]);
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}