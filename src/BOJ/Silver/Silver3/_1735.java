package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 분수 합
public class _1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        // 분자, 분모
        int numA = Integer.parseInt(stk.nextToken());
        int denA = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        int numB = Integer.parseInt(stk.nextToken());
        int denB = Integer.parseInt(stk.nextToken());

        // 분모는 두 분모의 최소공배수가 된다.
        // 최소공배수 = 두 수의 곱 / 최대공약수

        int newDen = 0;

        if (denA < denB)
            newDen = (denA * denB) / gcd(denA, denB);
        else
            newDen = (denA * denB) / gcd(denB, denA);

        // 새로운 분자
        int newNumA = numA * (newDen / denA);
        int newNumB = numB * (newDen / denB);

        int sumNum = newNumA + newNumB;

        // 기약 분수 구하기
        int divide = 0;

        if (sumNum < newDen) {
            divide = gcd(sumNum, newDen);
        } else {
            divide = gcd(newDen, sumNum);
        }

        int ansNum = sumNum / divide;
        int ansDen = newDen / divide;

        sb.append(ansNum).append(" ").append(ansDen);

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }


    static int gcd(int p, int q) {
        if (q==0) {
            return p;
        }
        return gcd(q, p%q);
    }


}