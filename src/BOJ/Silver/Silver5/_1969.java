package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// DNA
public class _1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        String[] dna = new String[n];
        for (int i = 0; i < n; i++) {
            dna[i] = buf.readLine();
        }

        // A C G T
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int[] count = new int[4];
            for (int j = 0; j < n; j++) {
                if (dna[j].charAt(i) == 'A') {
                    count[0]++;
                }
                if (dna[j].charAt(i) == 'C') {
                    count[1]++;
                }
                if (dna[j].charAt(i) == 'G') {
                    count[2]++;
                }
                if (dna[j].charAt(i) == 'T') {
                    count[3]++;
                }
            }

            int maxCount = 0;
            int maxCh = 0;

            for (int j=0; j<4; j++) {
                if (maxCount < count[j] || (count[j] == maxCh) && j < maxCh) {
                    maxCh = j;
                    maxCount = count[j];
                }
            }

            if (maxCh == 0) {
                sb.append('A');
            }
            if (maxCh == 1) {
                sb.append('C');
            }
            if (maxCh == 2) {
                sb.append('G');
            }
            if (maxCh == 3) {
                sb.append('T');
            }

            // n에서 가장 많이 나온 수를 뺀 결과가 해밍 거리.
            answer += (n - maxCount);
        }

        sb.append("\n").append(answer);
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}