package Programmers.Level2;

// 행렬 테두리 회전하기
public class MatrixBorderRotation {

    static int globalR = 0, globalC = 0;
    static int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    static int[][] matrix, temp;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;
        globalR = rows;
        globalC = columns;

        // 가장 왼쪽 끝은 (1,1)
        // rows -> 행렬의 세로 길이
        // columns -> 행렬의 가로 길이
        // queries -> 회전시킬 범위.

        matrix = new int[rows + 1][columns + 1];
        temp = new int[rows + 1][columns + 1];

        // 행렬 초기화
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = count++;
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            x1 = queries[i][0];
            y1 = queries[i][1];
            x2 = queries[i][2];
            y2 = queries[i][3];
            answer[ansIdx++] = rotateMatrix(x1, y1, x2, y2);
            copyArray();
        }


        return answer;
    }

    // (3,3) (6,6)
    // 대상 -> (3,3)(3,4)(3,5)(3,6) (4,3)(4,6) (5,3)(5,6) (6,3)(6,4)(6,5)(6,6)
    // 회전 -> (3,4)(3,5)(3,6)(4,6) (3,3)(5,6) (4,3)(6,6) (5,3)(6,3)(6,4)(6,5)
    //     (0,1)(0,1)(1,0)(1,0) (-1,0)(1,0) (-1,0)(1,0) (-1,0)(0,-1)(0,-1)(0,-1)

    // (2,2) (5,4)
    // 대상 -> (2,2)(2,3)(2,4) (3,2)(3,4) (4,2)(4,4) (5,2)(5,3)(5,4)
    // 회전 -> (2,3)(2,4)(3,4) (2,2)(4,4) (3,2)(5,4) (4,2)(5,2)(5,3)
    //        (0,1)(0,1)(1,0) (-1,0)(1,0) (-1,0)(1,0) (-1,0)(0,-1)(0,-1)

    private int rotateMatrix(int x1, int y1, int x2, int y2) {

        // 이동한 숫자의 최솟값 구하기.
        int minVal = 10001;

        // 테두리 먼저 뽑아내서 돌리기 진행하기.
        for (int i = 1; i <= globalR; i++) {
            for (int j = 1; j <= globalC; j++) {
                int origin = matrix[i][j];
                if (i == x1 && ((y1 <= j) && (j <= y2))) {
                    if (j == y2) {
                        temp[i + 1][j] = origin;
                        minVal = Math.min(minVal, origin);
                        continue;
                    }
                    temp[i][j + 1] = origin;
                    minVal = Math.min(minVal, origin);
                    continue;
                }
                if (((x1 < i) && (i < x2))
                        && ((y1 == j) || (y2 == j))) {
                    if (y1 == j) {
                        temp[i - 1][j] = origin;
                        minVal = Math.min(minVal, origin);
                        continue;
                    }
                    temp[i + 1][j] = origin;
                    minVal = Math.min(minVal, origin);
                    continue;
                }
                if (i == x2 && ((y1 <= j) && (j <= y2))) {
                    if (j == y1) {
                        temp[i - 1][j] = origin;
                        minVal = Math.min(minVal, origin);
                        continue;
                    }
                    temp[i][j - 1] = origin;
                    minVal = Math.min(minVal, origin);
                }
            }
        }

        return minVal;
    }

    private void copyArray() {
        // temp의 값을 matrix으로 복사시키기 (배열 업데이트)
        for (int i = 1; i <= globalR; i++) {
            for (int j = 1; j <= globalC; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
