package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 종이 자르기
public class _2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        int n = Integer.parseInt(buf.readLine());

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        row.add(0);
        row.add(y);

        col.add(0);
        col.add(x);

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (a == 0) {
                // 가로로 자르는 점선
                row.add(b);
                continue;
            }
            col.add(b);
        }

        row.sort(Comparator.naturalOrder());
        col.sort(Comparator.naturalOrder());

        int maxRow = 0;
        for (int i = 0; i < row.size()-1; i++) {
            maxRow = Math.max(maxRow, row.get(i+1) - row.get(i));
        }

        int maxCol = 0;
        for (int i = 0; i < col.size()-1; i++) {
            maxCol = Math.max(maxCol, col.get(i+1) - col.get(i));
        }

        System.out.println(maxRow * maxCol);

        buf2.flush();
        buf.close();
        buf2.close();
    }
}