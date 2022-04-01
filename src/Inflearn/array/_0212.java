package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12. 멘토링
public class _0212 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] test = new int[m][n];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                test[i][j] = Integer.parseInt(stk.nextToken());
            }
        }


        int result = 0;

        // 학생에 대한 루프 돌기
        // 1번-2번 / 1번-3번 / 1번-4번... 이런 식으로 비교
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                // 동일한 학생은 비교할 필요 없으니까 패스
                if(i==j)
                    continue;

                boolean check = true;

                // 학생 등수에 대한 루프 돌기
                for(int p=0; p<m; p++) {
                    // 첫 번째 학생에 대한 등수, 두 번째 학생에 대한 등수 저장
                    int rank1 = 0, rank2 = 0;
                    for(int q=0; q<n; q++) {
                        // 학생의 등수 저장
                        if (test[p][q] == i)
                            rank1 = q;
                        else if (test[p][q] == j)
                            rank2 = q;
                    }

                    // 첫 번째 학생의 등수보다 두 번째 학생의 등수가 하나라도 더 큰 게 있다면
                    // check 값을 false로 두기
                    if(rank1 < rank2)
                        check = false;
                }

                // 계속 check 값이 true = 첫 번째 학생의 등수가 계속 더 높았음을 의미
                // result 증가시켜주기
                if(check)
                    result++;
            }
        }

        System.out.println(result);


    }
}
