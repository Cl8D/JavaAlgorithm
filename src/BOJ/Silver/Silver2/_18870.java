package BOJ.Silver.Silver2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 좌표 압축
public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];
        int[] origin = new int[n];
        for(int i=0; i<n; i++) {
            int v = Integer.parseInt(stk.nextToken());
            origin[i] = v;
            val[i] = v;
        }

        // 좌표 압축 = 해당 좌표의 값을 그 값보다 작은 좌표들의 개수로 대체 (문제가 왤케 이해하기 어려워...?)
        Arrays.sort(val);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for(int i=0; i<val.length; i++) {
            if(!map.containsKey(val[i]))
                map.put(val[i], idx++);
        }

        for(int v : origin) {
            buf2.write(map.get(v) + " ");
        }

        buf2.flush();
        buf.close();
        buf2.close();
    }
}