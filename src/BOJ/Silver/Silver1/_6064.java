package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// 카잉 달력
public class _6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            stk = new StringTokenizer(buf.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            // 나머지가 0이 나오는 것을 방지
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;

            // cf) https://girawhale.tistory.com/10
            // m=10, n=12, x=1, y=11
            // 조건) 11번째: <1:11> ==> 11%10=1, 11%12=11

            // 모든 경우의 수 고려 = 시간 초과
            // x 값을 기준으로 조건 만족 확인 -> y값 조건 만족 확인
            // 구할 수 있는 최대 범위가 m과 n의 최대 공배수

            int lcm = m*n / gcd(m, n); // 범위
            boolean flag = false;

            // 이때 m만큼 증가시켜서 x값을 고정시키는 것
            // cf) https://1-7171771.tistory.com/38
            // ex) m=5, n=7일 때
            // 1번째: <1, 1> || 6번째: <1,6> || 11번째: <1,4> 이런 식이니까.
            for(int j=x; j<lcm; j+=m) {
                if(j%n == y) {
                    buf2.write(j+1 + "\n");
                    flag = true;
                    break;
                }
            }

            if(!flag)
                buf2.write("-1\n");

        }
        buf2.flush();
        buf.close();
        buf2.close();
    }


    // 최대공약수 구하기 - 유클리드 호제법 이용
    static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

}
