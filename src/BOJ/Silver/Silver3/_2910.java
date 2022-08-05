package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 빈도 정렬
public class _2910{
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 이렇게 map 2개로 안 두고 그냥 LinkedHashmap 쓰면 될 듯!!
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();

        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(buf.readLine());
        int order = 0;
        while(stk.hasMoreTokens()) {
            int val = Integer.parseInt(stk.nextToken());
            map.put(val, map.getOrDefault(val, 0) + 1);
            idx.put(val, idx.getOrDefault(val, order++));
        }


        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            if(Objects.equals(map.get(o1), map.get(o2)))
                return idx.get(o1) - idx.get(o2);
            return map.get(o2) - map.get(o1);
        });

        StringBuilder sb = new StringBuilder("");

        for(Integer i : list) {
            for (int j = 0; j < map.get(i); j++) {
                sb.append(i).append(" ");
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

}
