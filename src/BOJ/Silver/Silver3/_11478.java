package BOJ.Silver.Silver3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 서로 다른 부분 문자열의 개수
public class _11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String s = buf.readLine();
        Set<String> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<=s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }

        buf2.write(set.size()+"");
        buf.close();
        buf2.close();
    }
}
