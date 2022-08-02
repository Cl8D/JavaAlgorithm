package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 기타줄
public class _1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 끊어진 기타줄의 개수
        int n = Integer.parseInt(stk.nextToken());
        // 기타줄 브랜드 개수
        int m = Integer.parseInt(stk.nextToken());

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pack = new PriorityQueue<>();
        PriorityQueue<Integer> piece = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 패키지 가격(6개), 낱개 가격
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            pack.add(a);
            piece.add(b);
        }
        int answer = 1000000;
        if(n<=6) {
            // 적으면 그냥 패키지 한 개랑 개별만 비교
            answer = Math.min(piece.peek()*n, pack.peek());
        }
        else {
            // 패키지 여러 개, 개별 여러 개
            answer = Math.min(piece.peek()*n, pack.peek() * ((n/6) + 1));
            // 패키지랑 개별 혼합해서 구매하는 경우
            answer = Math.min(answer, piece.peek() * (n%6) + pack.peek() * (n/6));
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
