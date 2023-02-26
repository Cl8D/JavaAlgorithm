package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 기타 레슨
public class _2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());

        // 총 강의의 수
        int n = Integer.parseInt(stk.nextToken());

        // 블루레이의 개수
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        // 기타 강의의 길이
        int[] lectures = new int[n];
        int total = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(stk.nextToken());
            total += lectures[i];
            max = Math.max(lectures[i], max);
        }

        // 녹화 가능한 길이를 최소로 만들기.
        int answer = Integer.MAX_VALUE;
        int start = 0, end = total + 1;

        while (start <= end) {
            int temp = 0;
            int count = 1;

            int mid = (start + end) / 2;
            for (int lecture : lectures) {
                temp += lecture;
                if (temp > mid) {
                    temp = lecture;
                    count++;
                }
            }

            if (count <= m) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }

        // 강의 동영상의 최댓값보다 짧은 블루레이 시간이 정답이 될 수는 없다.
        // 강의를 다 녹화해야 하기 때문에 (잘라서 녹화 X)
        System.out.println(Math.max(answer, max));
        buf2.flush();
        buf.close();
        buf2.close();
    }
}