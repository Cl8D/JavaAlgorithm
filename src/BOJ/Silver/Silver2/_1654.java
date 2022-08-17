package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 랜선 자르기
public class _1654 {
    static int k, n;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        val = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            val[i] = Integer.parseInt(buf.readLine());
            max = Math.max(max, val[i]);
        }

        // n개보다 많이 만드는 것도 n개를 만드는 것에 포함된다!
        // 그리고, 랜선의 최대 길이를 구하는 것이기 때문에 상한값을 구해야 된다.
        // 예를 들어, 190cm 191cm 192cm 모두 잘랐을 때 n개가 나온다면 답이 192cm가 나와야 한다.
        // 이는 곧, 처음으로 n+1개가 나오는 경우보다 -1을 해줬을 때가 답이 된다는 것. (이게 중요...!!!)

        // 0으로 나눠지는 걸 방지하기 위해서
        // ex) min=0, max=1일 경우 mid=0이 나와서 0으로 나누어짐 => max 값 자체를 1을 더해주기
        // 이러면 min=0, max=2가 되어서 결과적으로 mid=1이 나옴
        // 어차피 우리는 상한값 -1의 값을 얻으니까 +1을 해줘도 된다.

        max++;
        long min = 0, mid=0;

        while(min < max) {
            // 이분 탐색
            mid = (min + max) / 2;

            // 몇 개가 만들어지는지 체크
            long ans = cut(mid);

            if(ans < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        buf2.write(min-1 + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static long cut(long height) {
        long ans = 0;
        for(int v : val) {
            ans += v / height;
        }
        return ans;
    }


}
