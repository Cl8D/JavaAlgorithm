package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 방 번호
public class _1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String[] str = buf.readLine().split("");
        int[] visited = new int[10];
        int[] limited = new int[10];
        int answer = 1;

        for(String s : str) {
            int val = Integer.parseInt(s);
            if(visited[val]<=limited[val]) visited[val]++;
            else {
                if(val == 6 && visited[9] <= limited[val])
                    visited[9]++;
                else if (val==9 && visited[6] <= limited[val])
                    visited[6]++;
                else {
                    answer++;
                    visited[val]++;
                    for (int i = 0; i < 10; i++) {
                        limited[i]++;
                    }
                }
            }
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
