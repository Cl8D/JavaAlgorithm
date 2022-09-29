package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 예산
public class _2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        int start = 0, end = -1;
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
            end = Math.max(end, val[i]);
        }
        // 총 예산
        int m = Integer.parseInt(buf.readLine());

        while(true) {
            // start 값이 더 커지면 중지
            if (start > end) {
                break;
            }
            // 이분탐색 시작
            int mid = (start + end) / 2;
            long temp = 0; // 총 값이 10^6 * 10^9라서 int 값 넘어갈수도!
            for (int i = 0; i < n; i++) {
                if (val[i] > mid) {
                    temp += mid; // 배정을 원하는 금액이 더 크면 중간값으로 세팅
                }
                else {
                    temp += val[i]; // 아니면 해당 값 그대로 넣기
                }
            }
            // 아직 총 예산보다 작으면 재탐색
            if (temp <= m) {
                start = mid + 1;
            } else { // 더 커졌으면 다시 탐색
                end = mid - 1;
            }
        }
        // 탐색 종료 후 가장 end 값이 결국 최대!
        System.out.println(end);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}