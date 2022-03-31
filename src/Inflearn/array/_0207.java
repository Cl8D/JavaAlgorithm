package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7. 점수 계산
public class _0207 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int result = 0;
        int cul = 0;

        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(stk.nextToken());

            if (temp == 1) {
                cul++;
                result += cul;
            }
            else {
                cul = 0;
            }
        }
        System.out.println(result);
    }
}
