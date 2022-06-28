package BOJ.Silver.Silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class _17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        Map<String, String> map = new HashMap<>();

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String site = stk.nextToken();
            String pwd = stk.nextToken();
            map.put(site, pwd);
        }
        for(int i=0; i<m; i++) {
            String find = buf.readLine();
            buf2.write(map.get(find));
            buf2.append("\n");
        }
        buf2.flush();
    }
}