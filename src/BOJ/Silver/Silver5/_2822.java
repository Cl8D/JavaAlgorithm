package BOJ.Silver.Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 점수 계산
public class _2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        List<Type> list = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            int v = Integer.parseInt(buf.readLine());
            list.add(new Type(v, i));
        }

        list.sort((o1, o2) -> o2.val - o1.val);
        int[] val = new int[5];
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            answer += list.get(i).val;
            val[i] = list.get(i).idx;
        }

        sb.append(answer).append("\n");

        Arrays.sort(val);
        for(int v : val)
            sb.append(v).append(" ");

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static class Type {
        int val;
        int idx;

        public Type(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}