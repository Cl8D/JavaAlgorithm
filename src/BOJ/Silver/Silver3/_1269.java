package BOJ.Silver.Silver3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 대칭 차집합
public class _1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<a; i++) {
            int val = Integer.parseInt(stk.nextToken());
            aSet.add(val);
        }

        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<b; i++) {
            int val = Integer.parseInt(stk.nextToken());
            bSet.add(val);
        }

        int temp1 = 0, temp2 = 0;
        for(int i : bSet) {
            if(!aSet.contains(i))
                temp1++;
        }

        for(int i : aSet){
            if(!bSet.contains(i))
                temp2++;
        }

        int result = temp1 + temp2;
        buf2.write(result+"");

        buf2.flush();
        buf.close();
        buf2.close();
    }
}
