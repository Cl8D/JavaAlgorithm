package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 빙고
public class _2578 {
    static int[][] val;
    static boolean[][] visited;
    static int bingo = 0, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        val = new int[5][5];
        visited = new boolean[5][5];

        // 빙고판에 써있는 수
        for (int i = 0; i < 5; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < 5; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 사회자가 부르는 수
        for (int i = 0; i < 5; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < 5; j++) {
                int v = Integer.parseInt(stk.nextToken());
                answer++;

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (val[k][l] == v) {
                            visited[k][l] = true;
                        }
                    }

                    checkHeight();
                    checkWidth();
                    checkLeftCross();
                    checkRightCross();

                    if(bingo >= 3) {
                        System.out.println(answer);
                        System.exit(0);
                    }
                    bingo = 0;
                }
            }
        }

        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void checkHeight() {
        for (int i = 0; i < 5; i++) {
            int temp = 0;
            for (int j = 0; j < 5; j++) {
                if (visited[j][i]) {
                    temp++;
                }
            }
            if(temp == 5) {
                bingo++;
            }
        }
    }

    private static void checkWidth() {
        for (int i = 0; i < 5; i++) {
            int temp = 0;

            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    temp++;
                }
            }
            if(temp == 5) {
                bingo++;
            }
        }


    }

    private static void checkLeftCross() {
        int temp = 0;
        for (int i = 0; i < 5; i++) {
            // 0,4 || 1,3 || 2,2 || 3,1 || 4,0
            if (visited[i][4-i]) {
                temp++;
            }
        }

        if(temp == 5) {
            bingo++;
        }
    }

    private static void checkRightCross() {
        int temp = 0;
        for (int i = 0; i < 5; i++) {
            // 0,0 || 1,1 || 2,2 || 3,3 || 4,4
            if (visited[i][i]) {
                temp++;
            }
        }

        if(temp == 5) {
            bingo++;
        }
    }

}