package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _9020 {
    // 에라토스테네스의 체

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(buf.readLine());
            List<Integer> prime = isPrime(val);

            int lh = val / 2;
            int rh = val / 2;

            // 반으로 나눈 다음에, 하나는 1씩 키우고 하나는 1씩 줄이기
            // 둘 다 소수인지 판단
            // 둘이 더한 값이 val인지 판단
            while(true) {
                if (prime.contains(lh) && prime.contains(rh)) {
                    if(lh + rh == val) {
                        System.out.println(rh + " " + lh);
                        break;
                    }
                }
                lh++;
                rh--;
            }
        }
    }

    private static List<Integer> isPrime(int n) {
        int[] temp = new int[n+1];
        List<Integer> prime = new ArrayList<>();

        temp[0] = temp[1] = 1;

        for(int i=2; i<=n; i++) {
            if(temp[i] == 0) {
                prime.add(i);
                for(int j=i*2; j<=n; j+=i) {
                    temp[j] = 1;
                }
            }
        }
        return prime;
    }
}
