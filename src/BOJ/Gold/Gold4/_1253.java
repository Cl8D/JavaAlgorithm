package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 좋다
public class _1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }


        Arrays.sort(values);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int target = values[i];
            int left = 0, right = n - 1;

            while (left < right) {
                int leftVal = values[left];
                int rightVal = values[right];

                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }

                int sum = leftVal + rightVal;

                if (sum == target) {
                    answer++;
                    break;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(answer);

        buf.close();
    }
}
