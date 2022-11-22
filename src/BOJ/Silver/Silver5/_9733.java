package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 꿀벌
public class _9733 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        // 원래 IDE에서는 안 돌아간다. 제출을 해야 알 수 있음...
        String str = null;
        while((str = buf.readLine()) != null) {
            String[] works = str.split(" ");
            for(String work : works) {
                map.put(work, map.getOrDefault(work, 0) + 1);
                count++;
            }
        }
        String[] bees = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
        for(String bee : bees) {
            if (!map.containsKey(bee)) {
                sb.append(bee).append(" ").append(0).append(" ").append("0.00").append("\n");
                continue;
            }
            int workCount = map.get(bee);
            String ratio = String.format("%.2f", (double) workCount / count);
            sb.append(bee).append(" ").append(workCount).append(" ").append(ratio).append("\n");
        }

        sb.append("Total ").append(count).append(" 1.00");
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}