package Programmers.Level1;

import java.util.*;

// 테이블 해시 함수
class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 열은 컬럼, 행은 튜플
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] == o2[col-1]) {
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        });


        for (int i=row_begin-1; i<=row_end-1; i++) {
            int temp = 0;
            for (int j=0; j<data[i].length; j++) {
                temp += data[i][j] % (i + 1);
            }
            answer = answer ^ temp;
        }

        return answer;
    }
}