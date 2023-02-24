package BOJ.Gold;

import java.io.*;
import java.util.*;

// 개똥벌레 (나중에 다시... 보기...)
public class _3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());

        int[] down = new int[h + 2];
        int[] up = new int[h + 2];

        for (int i = 1; i <= n / 2; i++) {
            // 1 3 5
            int a = Integer.parseInt(buf.readLine());

            // 5 3 1
            // 장애물의 높이를 a 값을 기준으로 컨버팅
            int b = h - Integer.parseInt(buf.readLine()) + 1;
            down[a]++; // 값의 개수 저장
            up[b]++;
        }

        // 누적합
        for (int i = 1; i <= h; i++) {
            // 높이가 i일 때 존재하는 장애물의 개수
            down[i] += down[i - 1];
        }

        // 역순으로 돌아준다
        for (int i = h; i >= 1; i--) {
            up[i] += up[i + 1];
        }

        // https://loosie.tistory.com/557
        int min = n; // 장애물의 최솟밗
        int count = 0; // 구간의 수
        for (int i = 1; i < h + 1; i++) {
            // down[h] : 누적합이니까 밑에 있는 장애물의 최대 개수
            // up[1] : 누적합이니까 위에 있는 장애물의 최대 개수

            int diff = (down[h] - down[i - 1]) + (up[1] - up[i + 1]);
            if (diff < min) {
                min = diff;
                count = 1;
            } else if (min == diff) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }

}
