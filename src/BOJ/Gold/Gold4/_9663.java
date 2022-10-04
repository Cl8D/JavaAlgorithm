package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// N-Queen
public class _9663 {
    static int n, answer=0;
    static int[] val;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 퀸은 상하좌우, 대각선으로 이동이 가능하다.
        /*
        # : start point

            #***
            **oo
            *o*o
            *oo*
            -> (1,2)(1,3) (2,1)(2,3) (3,1)(3,2) 이동 가능
         */
        n = Integer.parseInt(buf.readLine());

        // 2차원 배열 대신 1차원 배열로 선언
        // 각 배열의 인덱스는 열로, 인덱스에 해당하는 값을 행 값으로 생각하기
        val = new int[n];

        nQueens(0);

        buf2.write(answer+ "");
        nQueens(0);
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void nQueens(int depth) {
        if(depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            val[depth] = i;
            // 해당 depth에서 (열에서) i번째 행에 놓는 것이 유망한지 판단
            if(possibility(depth)) {
                nQueens(depth + 1);
            }
        }
    }

    static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i번째 열의 행이 일치할 경우
            // 왜냐하면 같은 행이라면 퀸의 이동 경로를 막게 되니까
            if(val[col] == val[i]) {
                return false;
            }
            // 대각선상에 놓여있을 경우
            // 열의 차와 행의 차가 동일할 경우 -> (1,1) (3,3) = 2,2로 모두 동일
            else if(Math.abs(col - i) == Math.abs(val[col]-val[i])) {
                return false;
            }
        }
        return true;
    }
}