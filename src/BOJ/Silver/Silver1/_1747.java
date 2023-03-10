package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수&팰린드롬
public class _1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buf.readLine());
        // 소수 판정 시 1인 경우는 무조건 제거해야 한다!
        if (n == 1) {
            System.out.println(2);
            return;
        }
        boolean isPrime;
        boolean isPalindrome;

        while (true) {
            isPrime = isPrime(n);
            isPalindrome = isPalindrome(String.valueOf(n));
            if (isPrime && isPalindrome) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    // 범위가 낮아서 굳이 에라토스테네스의 체를 사용하지 않아도 이렇게 해도 충분하다.
    private static boolean isPrime(final int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 팰린드롬도 그냥 쌩으로 돌면 된다.
    private static boolean isPalindrome(final String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
