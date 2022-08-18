package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 나무 자르기
public class _2805 {
    static int n, m;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        val = new int[n];
        stk = new StringTokenizer(buf.readLine());
        long max = 0;
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, val[i]);
        }

        max++;
        long min = 0, mid = 0;

        while(min < max) {
            mid = (min + max) / 2;
            long height = cut(mid);

            if(height < m) {
                max = mid;
            } else {
                // mid보다 그 다음 것부터 탐색해야 함!!
                min = mid + 1;
            }
        }

        // min 값은 상한값이니까 그 값보다 1 작은 값이 정답.
        buf2.write(min-1+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static long cut(long height) {
        long ans = 0;
        for(int v : val) {
            if(v>height)
                ans += (v - height);
        }
        return ans;
    }
}
