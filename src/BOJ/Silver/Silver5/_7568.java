package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 덩치
public class _7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] answer = new int[n];
        List<Man> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int weight = Integer.parseInt(stk.nextToken());
            int height = Integer.parseInt(stk.nextToken());
            list.add(new Man(weight, height));
        }
        for (int i = 0; i < n; i++) {
            int val = 1;
            Man currentMan = list.get(i);
            for(int j=0; j<n; j++) {
                Man newMan = list.get(j);
                if(currentMan.height < newMan.height && currentMan.weight < newMan.weight)
                    val++;

            }
            answer[i] = val;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer)
            sb.append(a).append(" ");
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static class Man {
        int weight;
        int height;

        public Man(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
