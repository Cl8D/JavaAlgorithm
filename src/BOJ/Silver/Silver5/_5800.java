package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 성적 통계
public class _5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int k = Integer.parseInt(buf.readLine());
        List<Integer>[] scoreByClass = new ArrayList[k];

        for (int i = 0; i < k; i++) {
            scoreByClass[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(buf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < n; j++) {
                scoreByClass[i].add(Integer.parseInt(stk.nextToken()));
            }
        }

        for (int i = 0; i < k; i++) {
            sb.append("Class ").append(i+1).append("\n");
            List<Integer> score = scoreByClass[i];
            score.sort(Collections.reverseOrder());
            sb.append("Max ").append(score.get(0)).append(", ");
            sb.append("Min ").append(score.get(score.size()-1)).append(", ");

            int maxGap = 0;
            for (int j = 0; j < score.size()-1; j++) {
                maxGap = Math.max(maxGap, Math.abs(score.get(j) - score.get(j+1)));
            }
            sb.append("Largest gap ").append(maxGap).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}