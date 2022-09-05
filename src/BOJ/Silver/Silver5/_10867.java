package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 중복 빼고 정렬하기
public class _10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stk.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder("");
        for(Integer val : list) {
            sb.append(val).append(" ");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
