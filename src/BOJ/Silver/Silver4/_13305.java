package BOJ.Silver.Silver4;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

// 주유소
public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] km = new int[n-1];
        int[] price = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n-1; i++) {
            // 도로의 길이 (km)
            km[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            // 리터당 가격
            price[i] = Integer.parseInt(stk.nextToken());
        }

        // 최소 비용이니까, 최대한 적은 가격일 때 주유하도록
        // 처음에는 그냥 직전 가격이랑만 비교했는데, 생각해 보니까 그냥 최대한 적은 주유소에서 다 채우고 가면 됐던 거였다...
        BigInteger minPrice = new BigInteger(String.valueOf(price[0]));

        // 우선 처음은 무조건 채워짐
        BigInteger answer = minPrice.multiply(new BigInteger(String.valueOf(km[0])));

        for (int i = 1; i < n-1; i++) {
            BigInteger curPrice = new BigInteger(String.valueOf(price[i]));
            BigInteger curKm = new BigInteger(String.valueOf(km[i]));

            if(minPrice.compareTo(curPrice) > 0) {
                minPrice = curPrice;
            }

            // 무조건 최소 금액에서 주유하도록!
            BigInteger temp = minPrice.multiply(curKm);
            answer = answer.add(temp);
        }

        buf2.write(answer+"");


        buf2.flush();
        buf.close();
        buf2.close();

    }
}
