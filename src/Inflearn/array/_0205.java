package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 소수 (에라토스테네스 체)
public class _0205 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        // 에라토스테네스의 체.
        // 1. 배열을 생성하여 자기자신의 값으로 초기화하기
        int[] val = new int[n+1];

        for(int i=2; i<=n; i++)
            val[i] = i;

        // 2. 2부터 시작하여 특정 수의 배수에 해당하는 수를 모두 지운다.
        // 이때 자기 자신이랑 이미 지워진 수는 건너뛴다.
        for(int i=2; i<=n; i++) {
            // 이미 지워진 수는 건너뛰기
            if(val[i] == 0)
                continue;

            // 배수에 해당하는 수를 모두 지우기 (자기자신 제외)
            for(int j=2*i; j<=n; j+=i)
                val[j] = 0;
        }

        // 3. 2부터 시작해서 남아있는 수 출력하기
        int count = 0;
        for(int i=2; i<=n; i++) {
            if (val[i] != 0)
                count++;
        }

        System.out.println(count);

    }
}
