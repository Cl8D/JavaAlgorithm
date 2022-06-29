package BOJ.Silver.Silver4;

import java.io.*;
import java.util.StringTokenizer;

// 문자열
public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        String a = stk.nextToken();
        String b = stk.nextToken();

        int answer = 100;

        for(int i=0; i<=b.length()-a.length(); i++) {
            // b에서 a 길이만큼 자른 문자열
            // 어차피 추가되는 문자열은 b를 기준으로 맞춰서 추가해주면 되니까 따로 생각할 필요 x
            String temp = b.substring(i, i+a.length());
            int diff = 0;

            for(int j=0; j<a.length(); j++) {
                if(a.charAt(j) != temp.charAt(j))
                    diff++;
            }
            answer = Math.min(answer, diff);
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }


}
