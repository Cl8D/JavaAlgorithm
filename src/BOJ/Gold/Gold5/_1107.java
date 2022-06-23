package BOJ.Gold.Gold5;

import java.io.*;
import java.util.StringTokenizer;

// 리모컨
public class _1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int m = Integer.parseInt(buf.readLine());

        String[] val = new String[m];

        if(m!=0) {
            stk = new StringTokenizer(buf.readLine());
            for (int i = 0; i < m; i++) {
                val[i] = stk.nextToken();
            }
        }

        // 초기 번호 100번
        // 단순히 +와 -를 사용하는 경우라면
        int answer = Math.abs(n-100);

        // n의 범위가 1~500000 -> 채널은 무한이니까 값을 찾을 때 10만까지 할 수 있음
        for(int i=0; i<=1000000; i++) {
            boolean flag = false;

            // 만약 고장난 숫자가 있다면
            String s = String.valueOf(i);

            for(String v: val) {
                if(s.contains(v)) {
                    flag = true;
                    break;
                }
            }

            if(!flag)
                answer = Math.min(answer, Math.abs(i-n) + String.valueOf(i).length());

        }

        buf2.write(String.valueOf(answer));
        buf2.flush();


        buf.close();
        buf2.close();
    }

}
