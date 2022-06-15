package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙
public class _1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken()); // 유저의 수
        int m = Integer.parseInt(stk.nextToken()); // 친구 관계의 수

        int[][] val = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i!=j)
                    // 처음에 Integer.MAX_VALUE 사용했는데 이러면 밑에서 int 계산할 때 오류나서... 다른 큰 값으로 넣어주었다
                    val[i][j] = 99999999;
            }
        }


        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            val[a][b] = val[b][a] = 1;
        }


        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    val[i][j] = Math.min(val[i][j], val[i][k] + val[k][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int answer = 0;

        // 1번의 케빈 베이컨 = val[1][2] + val[1][3] + val[1][4]...
        for(int i=1; i<=n; i++) {
            int total = 0;
            for(int j=1; j<=n; j++) {
                total += val[i][j];
            }

            if(result > total) {
                result = total;
                answer = i;
            }
        }

        // write 할 때 꼭 끝에 개행 붙여줘야 잘 출력된다. (그래야 string으로 인식하는 듯...?)
        buf2.write(answer + "\n");

        buf.close();
        buf2.close();
    }
}