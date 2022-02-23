package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());

        for(int i = 0; i<t; i++) {
            int answer = 1;

            StringTokenizer stk = new StringTokenizer(buf.readLine());
            // 문서의 개수
            int n = Integer.parseInt(stk.nextToken());

            // 몇 번째로 인쇄되었는지 궁금한 문서
            int m = Integer.parseInt(stk.nextToken());

            // 우선순위 큐 선언 - 내림차순 (=값이 높은 것부터 출력)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // 문서의 중요도를 저장하는 리스트
            List<Integer> list = new ArrayList<>();

            StringTokenizer stk2 = new StringTokenizer(buf.readLine());

            // 값 저장
            for(int j =0; j<n; j++) {
                int val = Integer.parseInt(stk2.nextToken());
                pq.add(val);
                list.add(val);
            }


            int cnt = 0;

            while(!pq.isEmpty()) {
                if(cnt != 0)
                    break;

                for(int k=0; k<n; k++) {
                    if(pq.peek() == list.get(k)) {
                        if (k == m) {
                            System.out.println(answer);
                            cnt++;
                            break;
                        }
                        answer++;
                        pq.poll();
                    }
                }
            }
        }
    }
}
