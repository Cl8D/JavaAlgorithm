package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 생일
public class _5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        List<People> list = new ArrayList<>();
        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String name = stk.nextToken();
            int day = Integer.parseInt(stk.nextToken());
            int month = Integer.parseInt(stk.nextToken());
            int year = Integer.parseInt(stk.nextToken());
            list.add(new People(name, day, month, year));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.year == o2.year) {
                if(o1.month == o2.month) {
                    return o1.day - o2.day;
                }
                return o1.month - o2.month;
            }
            return o1.year - o2.year;
        });

        StringBuilder sb = new StringBuilder();

        sb.append(list.get(list.size()-1).name).append("\n").append(list.get(0).name);
        buf2.write(sb.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static class People {
        String name;
        int day;
        int month;
        int year;

        public People(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
