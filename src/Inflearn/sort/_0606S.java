package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 6. 장난꾸러기 - 솔루션 코드
public class _0606S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[n];
        int[] val2 = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
            val2[i] = val[i];
        }

        Arrays.sort(val);

        // 굳이 어렵게 안 풀어도 된다.
        // 생각해보면 어차피 키가 큰 철수 값이 더 앞에 올 수밖에 없으니까.. 그대로 출력해도 됨.
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(val[i] != val2[i])
                answer.add(i+1);
        }

        for(int a : answer)
            System.out.print(a + " ");


    }
}
