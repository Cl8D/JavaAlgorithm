package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 수 정렬하기 2
public class _2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(buf.readLine());
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(Integer i : list)
            buf2.write(i+"\n");

        buf2.flush();
        buf.close();
        buf2.close();

    }

}

