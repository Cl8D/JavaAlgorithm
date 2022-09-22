package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 어린 왕자
public class _1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            // 출발점
            stk = new StringTokenizer(buf.readLine());
            int sx = Integer.parseInt(stk.nextToken());
            int sy = Integer.parseInt(stk.nextToken());

            // 도착점
            int ex = Integer.parseInt(stk.nextToken());
            int ey = Integer.parseInt(stk.nextToken());

            // 행성계의 개수
            int n = Integer.parseInt(buf.readLine());

            int answer = 0;
            for (int j = 0; j < n; j++) {
                stk = new StringTokenizer(buf.readLine());
                // 행성계 중점
                int cx = Integer.parseInt(stk.nextToken());
                int cy = Integer.parseInt(stk.nextToken());
                // 반지름
                int r = Integer.parseInt(stk.nextToken());

                // 원에 출발점, 도착점이 포함되어 있을 경우 = 두 점 사이의 거리보다 반지름이 더 큰 경우
                // = 이때는 진입 or 이탈이 무조건 일어날 수밖에 없다
                // 단, 하나의 원에서 출발, 도착점이 모두 포함되어 있는 경우는 제외한다. (하나의 원 안의 이동이라 진입/이탈 x)
                double disStart = Math.pow(Math.abs(sx - cx), 2) + Math.pow(Math.abs(sy-cy), 2);
                double disEnd = Math.pow(Math.abs(ex - cx), 2) + Math.pow(Math.abs(ey-cy), 2);
                if ((disStart < Math.pow(r, 2) && disEnd > Math.pow(r, 2)) ||
                        (disStart > Math.pow(r, 2) && disEnd < Math.pow(r, 2))) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}