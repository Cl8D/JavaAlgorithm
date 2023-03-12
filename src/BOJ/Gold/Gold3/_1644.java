package BOJ.Gold.Gold3;

import java.io.*;
import java.util.*;

// 소수의 연속합
public class _1644 {
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buf.readLine());
        if (n == 1) {
            System.out.println(answer);
            return;
        }

        List<Integer> primes = getPrimes(n);
        int start = 0, end = 0;
        int sum = 0;

        while (start <= end && end < primes.size()) {
            if (sum < n) {
                sum += primes.get(end);
                end++;
                continue;
            }

            if (sum == n) {
                answer++;
            }

            sum -= primes.get(start);
            start++;
        }

        System.out.println(answer);
        buf.close();
    }

    private static List<Integer> getPrimes(final int n) {
        List<Integer> primeNumbers = new ArrayList<>();

        // 주어진 범위 내의 소수를 일단 판독해둔다.
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        // 습관적으로 제곱근을 했었는데, 구체적인 이유에 대해서 몰랐던 것 같아서 여기에 정리해둠
        /**
         * 임의의 수 k가 소수가 아니라면, k는 a*b로 나타낼 수 있다.
         * 이때, a와 b 중에서 적어도 하나는 k의 제곱근보다 작거나 같아야 한다.
         * (아니라면, k=a*b라는 명제 자체가 깨지게 된다)
         * -> 수식으로 보면 a > sqrt(k) && b < sqrt(k)이거나, a < sqrt(k) && b > sqrt(k)여야 한다.
         * 둘 중 하나만 만족하더라도 되기 때문에, sqrt(k)까지의 수로 각 값들을 나누어 보면 된다.
         */
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) {
                continue;
            }
            // i*i부터 i씩 증가시키면서 MAX 이하인 i의 배수들을 모두 시작함.
            // i*i보다 작은 수는 이미 다른 소수의 배수로 체크된다.
            for (int j = i*i; j <= n; j+=i) {
                primes[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeNumbers.add(i);
            }
        }

        // 타겟이 소수라면 기본적으로 소수의 개수는 + 1.
        if (primes[n]) {
            answer++;
        }

        return primeNumbers;
    }
}
