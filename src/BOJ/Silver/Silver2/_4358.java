package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 생태학
public class _4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        while(true) {
            String s = buf.readLine();
            if(s == null || s.length()==0)
                break;
            map.put(s, map.getOrDefault(s, 0) + 1);
            total++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String s : list) {
            Double value = (double) map.get(s) / total * 100;
            buf2.write(s + " " + String.format("%.4f", value) + "\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }

}
