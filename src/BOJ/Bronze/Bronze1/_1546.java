package BOJ.Bronze.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int score[] = new int[n];

        StringTokenizer stk = new StringTokenizer(buf.readLine());

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(score);
        int m = score[score.length-1];

        double totalScore = 0.0;

        for(int i =0; i<n; i++) {
            double newScore = (double) score[i];
            newScore /= (double) m;
            newScore *= 100;
            totalScore += newScore;
        }

        System.out.println(totalScore/n);
    }
}
