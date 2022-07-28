package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 걸그룹 마스터 준석이
public class _16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String group = buf.readLine();
            int cnt = Integer.parseInt(buf.readLine());

            for (int j = 0; j < cnt; j++) {
                String name = buf.readLine();
                map.put(name, group);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String name = buf.readLine();
            if(Integer.parseInt(buf.readLine()) == 1) {
                sb.append(map.get(name)).append("\n");
            }
            else {
                List<String> answer = new ArrayList<>();
                for(String val : map.keySet()) {
                    if(map.get(val).equals(name))
                        answer.add(val);
                }
                Collections.sort(answer);
                for(String ans : answer) {
                    sb.append(ans).append("\n");
                }
            }

        }
        buf2.write(sb.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
