package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 최대 매출
public class _0303 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int result;
        int max = -1;
        for (int i = 0; i < val.length - k; i++) {
            result = 0;
            for (int j = 0; j < k; j++) {
                result += val[i + j];
            }
            max = Math.max(max, result);

            if(val[i] < val[i + k]){
                continue;
            } else if(val[i] > val[i + k]){
                i += 2;
            }
        }
        System.out.println(max);
    }
}
