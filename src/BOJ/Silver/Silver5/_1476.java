package BOJ.Silver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // E 1~15, S 1~28 M 1~19
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int e = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int result = 1;
        int temp_e = 1;
        int temp_s = 1;
        int temp_m = 1;

        while(true) {
            if(temp_e==e && temp_s==s && temp_m ==m)
                break;

            if(temp_e==16 || temp_s==29 || temp_m==20) {
                if (temp_e == 16)
                    temp_e = 1;
                if (temp_s == 29)
                    temp_s = 1;
                if (temp_m == 20)
                    temp_m = 1;
                continue;
            }

            temp_e++;
            temp_s++;
            temp_m++;
            result++;
        }

        System.out.println(result);

    }
}
