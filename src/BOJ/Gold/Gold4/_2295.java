package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 세 수의 합
public class _2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buf.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(buf.readLine());
        }

        Arrays.sort(values);
        int answer = 0;

        for (int i = 0; i < values.length; i++) {
            int target = values[i];
            for (int j = 0; j < values.length; j++) {
                int next = values[j];
                int start = 0, end = values.length - 1;
                while (start <= end) {
                    int sum = values[start] + values[end];
                    int result = sum + next;

                    if (target == result) {
                        answer = Math.max(answer, target);
                    }

                    if (result > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        System.out.println(answer);


        buf.close();
    }
}
