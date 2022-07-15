package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 문서 검색
public class _1543 {
    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        String str = buf.readLine();
        String find = buf.readLine();

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(sb.length() == find.length()) {
                if(sb.toString().equals(find)) {
                    answer++;
                    sb = new StringBuilder();
                }
                else
                    sb.deleteCharAt(0);
            }
            sb.append(str.charAt(i));
        }
        if(sb.toString().equals(find)) {
            answer++;
        }

        buf2.write(answer+"");

        buf2.flush();

        buf.close();
        buf2.close();

    }

}
