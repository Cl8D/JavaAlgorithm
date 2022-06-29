package BOJ.Silver.Silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 숫자 카드 2
public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        Map<Long, Integer> card = new HashMap<>();
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(stk.nextToken());
            card.put(num, card.getOrDefault(num, 0) + 1);
        }
        int m = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<m; i++) {
            long num = Long.parseLong(stk.nextToken());
            buf2.write(card.getOrDefault(num, 0) + " ");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
