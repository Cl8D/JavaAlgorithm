package BOJ.Silver.Silver3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 문자열 집합
public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            String val = buf.readLine();
            set.add(val);
        }

        int result = 0;
        for(int i=0; i<m; i++) {
            String find = buf.readLine();
            if(set.contains(find))
                result++;
        }

        buf2.write(result+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }


}
