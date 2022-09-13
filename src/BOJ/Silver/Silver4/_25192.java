package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 인사성 밝은 곰곰이
public class _25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        int n = Integer.parseInt(buf.readLine());
        for (int i = 0; i < n; i++) {
            String str = buf.readLine();
            if (str.equals("ENTER")) {
                map.clear();
                continue;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 1)
                answer++;
        }
        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}