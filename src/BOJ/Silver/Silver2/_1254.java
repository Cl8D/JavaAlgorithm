package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 팰린드롬 만들기
public class _1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        String str = buf.readLine();
        int answer = str.length();

        for (int i = 0; i < str.length(); i++) {
            // 앞에서부터 잘라서 검사를 진행한다.
            String substring = str.substring(i);

            // 투 포인터
            int start = 0, end = substring.length() -1;

            // 팰린드롬 검사
            boolean flag = false;

            while(start < end) {
                char st = substring.charAt(start++);
                char en = substring.charAt(end--);

                // 둘이 다른 지점이 나오면 팰린드롬이 아니게 된다.
                if (st != en) {
                    flag = true;
                    break;
                }
            }

            // 팰린드롬이라면
            if(!flag) {
                // 팰린드롬이 아니었던 것만큼 문자를 붙여주면 되기 때문에
                // 단순히 길이를 구하는 것이니까 i만큼 + 해주기.
                answer += i;
                break;
            }
        }
        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}