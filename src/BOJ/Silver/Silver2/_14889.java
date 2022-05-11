package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class _14889 {
    static int[][] board;
    static int n, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 능력치 S_ij = i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
        n = Integer.parseInt(buf.readLine());
        board = new int[n][n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(answer);

    }

    static void combi(int level, int start) {
        if(level==n/2) {
            int sVal=0, lVal=0;

            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    if(visited[i] && visited[j])
                        sVal += (board[i][j] + board[j][i]);
                    else if (!visited[i] && !visited[j])
                        lVal += (board[i][j] + board[j][i]);
                }
            }

            answer = Math.min(answer, Math.abs(sVal-lVal));

        }
        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(level+1, i+1);
                visited[i] = false;
            }
        }
    }
}
