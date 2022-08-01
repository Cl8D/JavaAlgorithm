package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// A->B
public class _16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        int answer = 1;

        // B->A로 찾기
        while(true) {
            String strB = String.valueOf(b);
            if(a==b) {
                buf2.write(answer+"");
                break;
            }
            // b가 1이면서 a가 1이 아니라면 잘못된 경우니까 break.
            if(b==1) {
                buf2.write("-1");
                break;
            }
            // 2로 나누어 떨어지는 경우
            if(b % 2 == 0) {
                b /= 2;
                answer++;
            }
            // 1로 끝나는 경우 제거해주기
            else if(strB.charAt(strB.length()-1) == '1') {
                b = Integer.parseInt(strB.substring(0, strB.length()-1));
                answer++;
            }
            // 모든 경우에도 포함되지 않은 경우 잘못된 수.
            else {
                buf2.write("-1");
                break;
            }
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }


}
