package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// 경로 찾기
public class _11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // bufferWriter 쓰는 것도 생각해보기...
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        int[][] val = new int[n][n];

        // 플로이드-워셜 알고리즘) 거쳐가는 정점을 기준으로 최단 거리 구하기
        // i->j = i->k->j 이런 식으로 생각하는 것.

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                int v = Integer.parseInt(stk.nextToken());
                if(v==1) {
                    val[i][j] = 1;
                }
            }
        }

        // k = 거쳐가는 노드
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    // (i, k) -> (k, j)로 갈 수 있는지 판단하기
                    // 갈 수 있으면 (i, j)의 값도 1이 되는 것.
                    if(val[i][k] == 1 && val[k][j]==1) {
                        val[i][j] = 1;
                    }
                }
            }
        }

        // 출력 최적화
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(val[i][j] + " ");
            }
            sb.append("\n");
        }

//        System.out.println(sb.toString());
        buf2.write(sb.toString());
        // flush를 해줘야 출력이 된다!
        buf2.flush();

        // 그리고 웬만하면 close 해주기.
        buf.close();
        buf2.close();


    }
}