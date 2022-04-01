package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2. 공통원소 구하기
public class _0302 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int[] a = new int[n];
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(stk.nextToken());

        int m = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] b = new int[m];

        for(int i=0; i<m; i++)
            b[i] = Integer.parseInt(stk.nextToken());

        int pt1=0, pt2=0;

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();

        while(pt1<n && pt2<m) {
            if(a[pt1] < b[pt2]) {
                pt1++;
                pt2=0;
            }

            else if (a[pt1] == b[pt2]) {
                answer.add(a[pt1]);
                pt1++;
                pt2=0;
            }

            else {
                pt2++;
            }
        }
        Collections.sort(answer);

        for(Integer an : answer)
            System.out.print(an + " ");
    }
}
