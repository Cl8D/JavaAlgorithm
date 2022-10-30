package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 이전 순열
public class _10973 {
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

        int idx = -1;
        // 5 4 3 2 1
        for (int i = n-1; i > 0; i--) {
            // 2 1
            if (val[i-1] > val[i]) {
                for (int j = n-1; j >= i; j--) {
                    if (val[i-1] > val[j]) {
                        swap(i, j);
                        idx = i-1;
                        break;
                    }
                }
                break;
            }
        }

        if(idx == -1) {
            sb.append(-1);
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
        for (int i = n-1; i > idx; i--) {
            sb.append(val[i]).append(" ");
        }
    }

    private static void swap(int i, int j) {
        int temp = val[i-1];
        val[i-1] = val[j];
        val[j] = temp;
    }
}