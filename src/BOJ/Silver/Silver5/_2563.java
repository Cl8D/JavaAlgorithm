package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 색종이
public class _2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 흰색 도화지의 가로/세로 크기는 100으로 고정
        // 검은색 도화지의 가로/세로 크기는 10으로 고정
        int[][] val = new int[100][100];

        // 색종이의 수
        int n = Integer.parseInt(buf.readLine());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());

            // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int x = Integer.parseInt(stk.nextToken());
            // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
            int y = Integer.parseInt(stk.nextToken());

            for (int j = x; j < x+10; j++) {
                for (int k = y; k <y+10 ; k++) {
                    // 어차피 크기가 고정이니깐 색종이가 붙는 부분을 1로 만들기
                    val[j][k] = 1;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (val[i][j] == 1) {
                    answer++;
                }
            }
        }
        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}