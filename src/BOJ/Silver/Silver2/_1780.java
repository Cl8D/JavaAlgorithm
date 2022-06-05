package BOJ.Silver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

// 종이의 개수
public class _1780 {
    static int n, cnt1=0, cnt2=0, cnt3=0;
    static int[][] val;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;


        // 삽질 내역) 초기화 이상하게 함 -> 변수 설정 잘못함 -> 예외 처리 안 함... (1일 경우...ㅎ) -> 알고 보니 문제 이해 잘못함... 실화냐
        // https://www.acmicpc.net/board/view/36841 이분과 똑같이 문제를 잘못 이해하고 있었다... ㅎㅎㅎㅎㅎ
        n = Integer.parseInt(buf.readLine());
        val = new int[n][n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        recur(0, 0, n);

        System.out.println(cnt1); // -1
        System.out.println(cnt2); // 0
        System.out.println(cnt3); // 1

    }

    static void recur(int x, int y, int size) {
        // 만약 다 같은 색이라면
        if(check(x, y, size)) {
            if(val[x][y] == -1)
                cnt1++;
            else if(val[x][y] == 0)
                cnt2++;
            else
                cnt3++;

            return;
        }


        int newSize = size / 3;
        recur(x, y, newSize);
        recur(x+newSize, y, newSize);
        recur(x+newSize*2, y, newSize);

        recur(x, y+newSize, newSize);
        recur(x+newSize, y+newSize, newSize);
        recur(x+newSize*2, y+newSize, newSize);

        recur(x, y+newSize*2, newSize);
        recur(x+newSize, y+newSize*2, newSize);
        recur(x+newSize*2, y+newSize*2, newSize);
    }

    private static boolean check(int x, int y, int size) {
        int start = val[x][y];
        for(int i = x; i< x + size; i++) {
            for(int j = y; j< y + size; j++) {
                if(start != val[i][j])
                    return false;
            }
        }
        return true;
    }
}