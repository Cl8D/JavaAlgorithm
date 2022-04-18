package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6. 부분집합 구하기 (DFS)
public class _0706 {
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        visited = new boolean[n+1];

        dfs(1);
    }

    static void dfs(int val) {
        // 트리의 끝지점(종착점)에 왔을 때.
        // 만약 n=3이라면 dfs(4)인 지점
        if(val==n+1) {
            for(int i=0; i<visited.length; i++) {
                if(visited[i] == true)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
        else{
            // 이진트리라고 고려했을 때, 각각의 val은 부분집합이 될 경우와 되지 않을 경우
            // 이렇게 2가지의 경우가 생길 수 있다.
            // 여기서 왼쪽은 부분집합이 될 경우, 오른쪽은 부분집합이 되지 않을 경우로 생각하자.

            // 하나는 왼쪽으로 뻗는 지점
            // 사용한다는 의미로 visited 배열의 해당 인덱스의 값을 True로 변경한다.
            visited[val] = true;
            dfs(val+1);

            // 하나는 오른쪽으로 뻗는 지점
            visited[val] = false;
            dfs(val+1);
        }
    }
}


