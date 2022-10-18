package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 플로이드
public class _11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 도시의 개수
        int n = Integer.parseInt(buf.readLine());
        // 버스의 개수
        int m = Integer.parseInt(buf.readLine());

        int[][] val = new int[n+1][n+1];
        final int max = 10000001;

        // 초기값은 비용의 최대값보다 더 큰 수로 지정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                val[i][j] = max;
            }
        }

        // i -> j로 가는데 필요한 최소 비용 출력. 갈 수 없는 경우 0.
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 출발 도시의 번호
            int start = Integer.parseInt(stk.nextToken());
            // 도착 도시의 번호
            int end = Integer.parseInt(stk.nextToken());
            // 한 번 타는데 드는 비용
            int cost = Integer.parseInt(stk.nextToken());

            // 다른 버스일지라도 같은 노선이 들어올 수 있기 때문에 더 적은 비용을 가지는 노선만 채택
            if (val[start][end] > 0) {
                val[start][end] = Math.min(val[start][end], cost);
            } else {
                val[start][end] = cost;
            }
        }

        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(val[i][k] != 0 && val[k][j] != 0) {
                        val[i][j] = Math.min(val[i][j], val[i][k] + val[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 자기 자신에 대해서는 0으로 처리
                if (i==j) {
                    sb.append(0).append(" ");
                    continue;
                }
                // max인 경우는 초기값에서 변화가 없는 경우니까, 곧 갈 수 없는 경로임. 0으로 수정해준다.
                if (val[i][j] == max) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(val[i][j]).append(" ");
            }
            sb.append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}