package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 카드
public class _11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Map<Long, Integer> map = new HashMap<>();

        // cf) parse vs valueOf
        // parse -> primitive로 리턴, valueof은 Integer 같은 객체로 리턴
        for(int i=0; i<n; i++) {
            long val = Long.parseLong(buf.readLine());
            map.put(val, map.getOrDefault(val, 0) + 1);
        }


        Integer maxVal = Collections.max(map.values());

        List<Long> list = new ArrayList<>();
        for(Long key : map.keySet()) {
            if(Objects.equals(map.get(key), maxVal))
                list.add(key);
        }

        Collections.sort(list);

        buf2.write(list.get(0)+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
