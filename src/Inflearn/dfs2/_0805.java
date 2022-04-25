package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 5. 동전교환
public class _0805 {
    static Integer[] coin;
    static int n, m, result=999;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 동전의 종류 개수
        n = Integer.parseInt(buf.readLine());

        coin = new Integer[n];

        // 동전 종류
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            coin[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(coin, Collections.reverseOrder());

        // 거슬러 줄 금액
        m = Integer.parseInt(buf.readLine());
        temp = new int[m];
        dfs(0, 0);
        System.out.println(result);
    }

    // l -> 동전의 개수
    // sum -> l개의 동전으로 만든 금액
    static void dfs(int l, int sum) {
//        System.out.println("sum = " + sum);
        if(sum > m)
            return;
        if(l >= result)
            return;
        if(sum == m) {
            result = Math.min(result, l);
        }
        else {
            for(int i=0; i<n; i++)
                dfs(l+1, sum+coin[i]);
        }
    }
}

/*
coin 배열에 3개의 값이 있는데,
level이 증가하면서 각 인덱스의 어느 값을 더 참조할 것인지 뻗어나가는 형식인 느낌.
인덱스로 뻗어나간다고 생각해야 할 것 같다.
 */
