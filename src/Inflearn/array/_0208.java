package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 8. 등수 구하기
public class _0208 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int[] score = new int[n];
        Integer[] sortScore = new Integer[n];

        for(int i=0; i<n; i++) {
            score[i] = Integer.parseInt(stk.nextToken());
            sortScore[i] = score[i];
        }

        Arrays.sort(sortScore, Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (score[i] == sortScore[j]) {
                    System.out.print(j+1 + " ");
                    break;
                }
            }
        }

        // 87 100 100 100 76
        // 100 100 100 87 76
        // 4 1 1 1 5


    }
}
