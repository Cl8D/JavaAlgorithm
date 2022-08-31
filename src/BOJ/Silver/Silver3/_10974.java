package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 모든 순열
public class _10974 {
    static int n;
    static int[] temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());

        temp = new int[n];
        visited = new boolean[n+1];
        recur( 0);

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
    static void recur(int level) {
        if(level==n) {
            for (int i = 0; i < n; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[level] = i;
                recur(level+1);
                visited[i] = false;
            }
        }
    }
}
