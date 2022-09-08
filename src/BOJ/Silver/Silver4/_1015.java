package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 수열 정렬
public class _1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        Type[] val = new Type[n];

        // val ==> (0, 2) (1, 3) (2, 1)
        for (int i = 0; i < n; i++) {
            val[i] = new Type(i, Integer.parseInt(stk.nextToken()));
        }

        // 문제 이해가 너무 빡세다...
        // A[0] = 2, A[1] = 3, A[2] = 1
        // B[P[i]] = A[i]
        // B[P[0]] = 2, B[P[1]] = 3, B[P[2]] = 1

        // 비내림차순이니까 오름차순으로 바꿔주기
        // 1 = B[P[2]] = B[0], 2 = B[P[0]] = B[1], 3 = B[P[1]] = B[2]
        // 결과적으로 P[2]=0, P[0]=1, P[1]=2...!
        // 그래서 답이 1, 2, 0...

        // y값을 기준으로 오름차순 정렬하기
        // (2, 1) (0, 2) (1, 3)
        Arrays.sort(val, (o1, o2) -> {
            if (o1.y == o2.y)
                return o1.x - o2.x;
            return o1.y - o2.y;
        });
        // 결과) (2, 1) (0, 2) (1, 3)

        // 정렬 후 각각에 대한 y 값을 바꿔주기
        int cnt = 0;
        for(Type t : val) {
            t.y = cnt++;
        }
        // 결과:  (2, 0) (0, 1) (1, 2)

        // x를 기준으로 이제 오름차순 정렬해주기
        Arrays.sort(val, (o1, o2) -> {
            return o1.x - o2.x;
        });

        // 결과: (0, 1) (1, 2) (2, 0)
        StringBuilder sb = new StringBuilder("");
        for(Type v : val) {
            sb.append(v.y).append(" ");
        }
        buf2.write(sb.toString());

        buf.close();
        buf2.close();
    }

    static class Type {
        int x;
        int y;

        public Type(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}