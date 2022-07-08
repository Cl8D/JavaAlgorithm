package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 보물
public class _1026 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        Integer[] a = new Integer[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            b[i] = Integer.parseInt(stk.nextToken());


        // 문제에서는 B를 건들지 말라고 했지만,
        // 실제로 최솟값을 구해보면 b의 가장 작은 값이 a의 가장 큰 값과 매칭된다.
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b);

        int answer = 0;
        for(int i=0; i<n; i++)
            answer += a[i] * b[i];

        buf2.write(answer + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }


}
