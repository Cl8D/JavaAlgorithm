package BOJ.Silver.Silver5;

import java.io.*;
import java.util.StringTokenizer;

// 그룹 단어 체커
public class _1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int answer = 0;

        for(int i=0; i<n; i++) {
            String s = buf.readLine();
            boolean isGroup = true;
            boolean[] visited = new boolean[26];
            char before = 0;

            for(char c : s.toCharArray()) {
                boolean flag = false;
                if (c==before) {
                    flag = true;
                }

                if(!flag && visited[c-97]) {
                    isGroup = false;
                    break;
                }

                visited[c-97] = true;
                before = c;
            }

            if(isGroup)
                answer++;
        }


        buf2.write(answer+"");
        buf2.flush();

        buf.close();
        buf2.close();
    }
}
