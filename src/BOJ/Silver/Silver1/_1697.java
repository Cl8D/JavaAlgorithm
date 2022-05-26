package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class _1697 {
    static int n, m;
    static boolean[] visited;
    static Queue<Type> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 수빈이 위치
        n = Integer.parseInt(stk.nextToken());
        // 동생
        m = Integer.parseInt(stk.nextToken());

        visited = new boolean[100001];
        queue = new LinkedList<>();
        queue.add(new Type(n, 0));
        visited[n] = true;

        while(!queue.isEmpty()) {
            Type cur = queue.poll();

            if (cur.current == m) {
                System.out.println(cur.count);
                break;
            }

            for(int i=0; i<3; i++) {
                int next = 0;
                if(i==0)
                    next = cur.current + 1;
                else if(i==1)
                    next = cur.current - 1;
                else
                    next = cur.current * 2;

                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Type(next, cur.count+1));
                }
            }

        }

    }


    static class Type {
        int current;
        int count;

        public Type(int current, int count) {
            this.current = current;
            this.count = count;
        }
    }
}