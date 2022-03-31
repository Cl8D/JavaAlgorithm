package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2. 보이는 학생
public class _0202 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        StringTokenizer stk = new StringTokenizer(buf.readLine());
        int[] student = new int[n];

        for(int i=0; i<n; i++) {
            student[i] = Integer.parseInt(stk.nextToken());
        }

        int max = 0;
        int result = 0;
        for(int s : student) {
            int before = max;
            max = Math.max(max, s);

            if (before < max)
                result++;
        }

        System.out.println(result);

    }
}
