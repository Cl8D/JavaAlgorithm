package BOJ.Silver.Silver4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 수 찾기
public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(stk.nextToken());
            set.add(val);
        }

        int m = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<m; i++) {
            int val = Integer.parseInt(stk.nextToken());
            if(set.contains(val))
                buf2.write("1\n");
            else
                buf2.write("0\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();
    }

}