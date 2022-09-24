package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 파일 정리
public class _20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(buf.readLine());
        for (int i = 0; i < n; i++) {
            String[] strArr = buf.readLine().split("\\.");
            map.put(strArr[1], map.getOrDefault(strArr[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}