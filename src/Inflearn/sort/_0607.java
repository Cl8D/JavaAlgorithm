package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 7. 좌표 정렬
public class _0607 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        int[][] val = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            val[i][0] = Integer.parseInt(stk.nextToken());
            val[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(val, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });

        for(int i=0; i<n; i++) {
            System.out.println(val[i][0] + " " + val[i][1]);
        }

    }
}
