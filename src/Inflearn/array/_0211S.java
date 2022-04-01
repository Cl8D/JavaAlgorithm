package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 11. 임시 반장 정하기 - 솔루션 코드
public class _0211S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int[][] grade = new int[n][5];

        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<5; j++) {
                grade[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int max = -1;
        int result = 0;


        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if (i==j)
                    continue;

                for(int k=0; k<5; k++) {
                    if (grade[i][k] == grade[j][k]) {
                        count++;
                        // 굳이 set을 쓸 필요 없이 그냥 break를 걸어주면 된다.
                        break;
                    }
                }
            }

            int before_max = max;
            max = Math.max(max, count);

            if(before_max < max) {
                result = i + 1;
            }
        }

        System.out.println(result);

    }
}
