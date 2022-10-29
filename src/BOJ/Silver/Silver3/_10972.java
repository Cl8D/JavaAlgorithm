package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 다음 순열
public class _10972 {
    static int n;
    static int[] val;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        sb = new StringBuilder("");

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // next_permutation custom 구현하기
        // 1 2 5 4 3
        int idx = -1;
        for (int i = n-1; i > 0; i--) {
            // 끝에서부터 2개씩 탐색하면서 val[i-1] < val[i] 경우를 찾기
            // val[i-1] = 2, val[i] = 5
            if (val[i-1] < val[i]) {
                // 끝에서부터 재탐색하면서 val[i-1]보다 처음으로 큰 수 찾기
                // 이때, val[i-1]보다 오른쪽에 있는 값이어야 한다.
                for (int j = n-1; j >= i; j--) {
                    if (val[j] > val[i-1]) {
                        // val[j] = 3, j=4
                        // 발견하면 두 값의 위치를 바꾼다.
                        // 1 3 5 4 2
                        swap(i-1, j);
                        idx = i-1;
                        break;
                    }
                }
                break;
            }
        }
        if (idx == -1) {
            // 마지막 수열이면 -1 리턴
            sb.append("-1");
        } else {
            getAnswer(idx);
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void getAnswer(int idx) {
        for (int i = 0; i <= idx; i++) {
            sb.append(val[i]).append(" ");
        }

        // i 이후의 값은 뒤집기 (뒤집을 때 괜히 StringBuilder 쓰면서 하면... 2글자 이상일 때 망한다...ㅎ
        for (int i = n-1; i > idx; i--) {
            sb.append(val[i]).append(" ");
        }
    }

    private static void swap(int i, int j) {
        int temp = val[i];
        val[i] = val[j];
        val[j] = temp;
    }

}