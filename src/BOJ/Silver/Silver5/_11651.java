package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 좌표 정렬하기 2
public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        List<Type> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list.add(new Type(x, y));
        }

        Collections.sort(list, new Comparator<Type>() {
            @Override
            public int compare(Type o1, Type o2) {
                if(Objects.equals(o1.y, o2.y))
                    return o1.x.compareTo(o2.x);
                else
                    return o1.y.compareTo(o2.y);
            }
        });

        for(Type o : list){
            buf2.write(o.x + " " + o.y + "\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static class Type {
        Integer x;
        Integer y;

        public Type(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
