package BOJ.Silver.Silver4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 암기왕
public class _2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            Set<Integer> set = new HashSet<>();

            int n = Integer.parseInt(buf.readLine());
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                int val = Integer.parseInt(stk.nextToken());
                set.add(val);
            }
            int m = Integer.parseInt(buf.readLine());
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<m; j++) {
                int val = Integer.parseInt(stk.nextToken());
                if(set.contains(val))
                    buf2.write("1\n");
                else
                    buf2.write("0\n");
            }
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
