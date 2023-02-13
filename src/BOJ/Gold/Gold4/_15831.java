package BOJ.Gold.Gold4;

import java.io.*;
import java.util.StringTokenizer;

// 준표의 조약돌
public class _15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");
        stk = new StringTokenizer(buf.readLine());

        // 조약돌의 총 개수
        int n = Integer.parseInt(stk.nextToken());

        // 검은 조약돌의 최대 개수
        int b = Integer.parseInt(stk.nextToken());

        // 흰색 조약돌의 최소 개수
        int w = Integer.parseInt(stk.nextToken());

        char[] stones = buf.readLine().toCharArray();

        int start = 0, end = 0;
        int white = 0, black = 0;

        int answer = 0;
        while (end < n) {
            if (black > b) {
                if (stones[start] == 'W') {
                    white--;
                } else {
                    black--;
                }
                start++;
            } else {
                end++;
                if (stones[end-1] == 'W') {
                    white++;
                } else {
                    black++;
                }
            }

            if (white >= w && black <= b) {
                answer = Math.max(answer, end - start);
            }
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }

}