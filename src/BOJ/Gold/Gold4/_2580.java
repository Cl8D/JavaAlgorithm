package BOJ.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠
public class _2580 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        board = new int[9][9];

        for(int i=0; i<9; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<9; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0, 0);

    }

    static boolean check(int x, int y, int val) {
        // 같은 행 검사
        for(int i=0; i<9; i++) {
            if(board[x][i] == val)
                return false;
        }

        // 같은 열 검사
        for(int i=0; i<9; i++) {
            if(board[i][y] == val)
                return false;
        }

        // 3x3 검사
        // (i, j)에 속하는 3x3의 첫 위치 -> (0,0)(0,3)(0,6) (3,0)(3,3)(3,6) (6,0)(6,3)(6,6)
        int row = (x/3) * 3;
        int col = (y/3) * 3;

        for(int i=row; i<row+3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == val)
                    return false;
            }
        }

        return true;
    }

    static void dfs(int x, int y) {

        // 행이 다 채워진 경우 다음 행 시작 (첫 번째 열부터!)
        if(y == 9) {
            dfs(x+1, 0);
            return;
        }

        // 마지막까지 다 채워진 경우
        if(x == 9) {
            // 출력 진행
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // 종료
            System.exit(0);
        }

        // 값이 0이라면 채워야 되는 곳
        if(board[x][y] == 0) {
            // 1~9까지 값 검사
            for(int i=1; i<=9; i++) {
                // 검사했을 때 true가 나온 값 = 1~9에서 겹치지 않는 값!
                if(check(x, y, i)) {
                    // 해당 값으로 넣어주기
                    board[x][y] = i;
                    // 다음 칸 검사
                    dfs(x, y+1);
                }
            }

            // 백트랙킹 진행
            board[x][y] = 0;
            return;
        }

        // 0이 아니라면 그냥 다음 칸 검사
        dfs(x, y+1);

    }

}
