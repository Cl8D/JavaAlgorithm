package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 터렛
public class _1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(buf.readLine());

            // 조규현 좌표
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());

            // 조규현이 계산한 류재명과의 거리
            int r1 = Integer.parseInt(stk.nextToken());

            // 백승환 좌표
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            // 백승환이 계산한 류재명과의 거리
            int r2 = Integer.parseInt(stk.nextToken());

            // 중심이 (x1, y1)이면서 반지름이 r1인 원과 (x2, y2)이면서 r2인 원의 접점의 개수를 구해주기
            double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

            // 1. 두 원이 완전히 겹쳐진 경우 = 무한대인 경우 = -1
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append("-1").append("\n");
            }

            // 2. 두 원의 반지름 합보다 두 원의 중점간의 거리가 더 길 때
            // 3. 원 내부에 원이 있는데 내접하지 않을 때 = 0개
            else if (distance > Math.pow(r1 + r2, 2) || distance < Math.pow(r1 - r2, 2)) {
                sb.append("0").append("\n");
            }

            // 4. 한 점에서 두 원이 만나는 경우 (내접, 외접) = 1개
            else if (distance == Math.pow(r1 - r2, 2) || distance == Math.pow(r1 + r2, 2)) {
                sb.append("1").append("\n");
            }

            // 5. 그냥 일반적인 경우 = 2개
            else {
                sb.append("2").append("\n");
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
