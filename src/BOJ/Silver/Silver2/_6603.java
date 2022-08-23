package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 로또
public class _6603 {
    static int k;
    static int[] val, temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while(true) {
            stk = new StringTokenizer(buf.readLine());
            k = Integer.parseInt(stk.nextToken());
            if(k==0)
                break;

            val = new int[k];
            for (int i = 0; i < k; i++) {
                val[i] = Integer.parseInt(stk.nextToken());
            }
            temp = new int[6];
            visited = new boolean[k];
            recur(0,0);
            sb.append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void recur(int start, int level) {
        if(level == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
        }
        else {
            for (int i = start; i < k; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[level] = val[i];
                    recur(i+1, level+1);
                    visited[i] = false;
                }
            }
        }
    }
}
