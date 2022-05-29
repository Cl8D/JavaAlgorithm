package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 회의실 배정
public class _1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        int[][] val = new int[n][2];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            val[i][0] = Integer.parseInt(stk.nextToken());
            val[i][1] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(val, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간을 기준으로 정렬하기
                return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });


        // 이전의 종료시간보다 다음의 시작시간이 커야 함!
        int prev = val[0][1];
        int count = 1;
        for(int i=1; i<n; i++) {
            if(prev <= val[i][0]) {
                prev = val[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}