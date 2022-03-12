package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int[] p = new int[n];

        for(int i=0; i<n; i++)
            p[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(p);

        int result = 0;

        for(int i=0; i<n; i++) {
            result += p[i] * (n-i);
        }

        System.out.println(result);
    }
}
