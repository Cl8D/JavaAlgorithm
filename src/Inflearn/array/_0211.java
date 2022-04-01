package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 11. 임시 반장 정하기
public class _0211 {
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
            HashSet<Integer> student = new HashSet<>();
            for(int j=0; j<n; j++) {
                if (i==j)
                    continue;

                // (0,0) (1,0) (2,0) / (0,1) (1,1)
                for(int k=0; k<5; k++) {
                    if (grade[i][k] == grade[j][k]) {
                        // 이전에 겹쳤던 학생은 다시 체크하지 않기 위해 set을 이용해서 중복 제거
                        student.add(j);
                    }
                }
            }

            // 같은 반이 되었던 학생들만 남음
            count = student.size();
            int before_max = max;
            max = Math.max(max, count);

            if(before_max < max) {
                result = i + 1;
            }
            ;
        }

        System.out.println(result);

    }
}
