package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10. 봉우리 - 솔루션 코드
public class _0210S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int[][] grid = new int[n+2][n+2];

        for(int i=1; i<=n; i++) {
            StringTokenizer stk = new StringTokenizer(buf.readLine());
            for(int j=1; j<=n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int count = 0;
        // 탐색할 위치의 인덱스를 미리 계산하는 방법
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                boolean flag = true;
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = i+dy[k];

                    if(nx>=0 && nx<n && ny>=0 && ny <n) {
                        // 주변의 값이 더 높다면
                        if (grid[nx][ny] >= grid[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag)
                    count++;
            }
        }

        System.out.println(count);

    }
}
