package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 동전 0
public class _11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Integer[] val = new Integer[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(buf.readLine());
        }

        Arrays.sort(val, Collections.reverseOrder());

        int rest = k;
        int answer = 0;

        for(int v : val) {
            if(v > rest)
                continue;
            answer += (rest / v);
            rest %= v;
        }

        System.out.println(answer);



    }
}