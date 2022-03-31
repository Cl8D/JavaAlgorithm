package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 베트르랑 공준
public class _4948 {
    // 에라토스테네스의 체
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(buf.readLine());
        while(num != 0) {
            int result = isPrime(num, 2*num);
            System.out.println(result);
            num = Integer.parseInt(buf.readLine());
        }
    }

    private static int isPrime(int n1, int n2) {
        int[] prime = new int[n2+1];
        prime[0] = prime[1] = 1;

        // 속도 최적화 (sqrt)
        for(int i=2; i<=Math.sqrt(n2); i++) {
            if (prime[i] == 0) {
                for(int j=i*2; j<=n2; j+=i) {
                    prime[j] = 1;
                }
            }
        }

        int cnt = 0;

        for(int i=n1+1; i<=n2; i++) {
            if (prime[i] == 0)
                cnt++;
        }
        return cnt;

    }
}
