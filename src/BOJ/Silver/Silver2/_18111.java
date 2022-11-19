package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 마인크래프트
public class _18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        int initB = b;
        int[][] map = new int[n][m];

        int min = 257;
        int max = -1;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(stk.nextToken());
                map[i][j] = v;
                max = Math.max(max, v);
                min = Math.min(min, v);
            }
        }

        int maxHeight = 0;
        int time = 1999999999;

        // 땅의 높이에 대해 최수부터 최댓값까지 다 고려해봐야 한다.
        // 중간 높이에 대해서도 경우의 수가 될 수 있으니까!
        for(int val = min; val<=max; val++) {
            b = initB;
            int removeCnt = 0;
            int tempTime = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == val) {
                        continue;
                    }

                    if (map[i][j] < val) {
                        int pour = val - map[i][j];
                        removeCnt += pour;
                        continue;
                    }

                    if (map[i][j] > val) {
                        // 파내야 되는 값
                        int pour = map[i][j] - val;
                        b += pour;
                        tempTime += (2*pour);
                    }
                }
            }

            // 당장에는 부족하더라도, 나중에 퍼오면서 늘어날 수 있기 때문에 마지막 부분에서 땅을 메꾸는 작업 실행.
            if (removeCnt <= b) {
                tempTime += removeCnt;
                if (time >= tempTime && tempTime != 0) {
                    time = tempTime;
                    maxHeight = Math.max(maxHeight, val);
                }
            }
        }

        // 값이 변하지 않았을 경우 - 이미 고른 땅인 경우
        if (time == 1999999999) {
            time = 0;
            maxHeight = min;
        }

        buf2.write(time + " " + maxHeight);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}