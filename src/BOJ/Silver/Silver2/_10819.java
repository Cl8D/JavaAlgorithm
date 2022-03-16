package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {
    static int[] temp, num;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());
        num = new int[t];
        // 바꾼 순서대로 수를 담은 배열
        temp = new int[t];
        visited = new boolean[t];
        StringTokenizer stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < t; i++)
            num[i] = Integer.parseInt(stk.nextToken());

        dfs(t, 0);
        System.out.println(result);
    }

    // 모든 경우를 탐색해나가는데, dfs로 깊게 들어가면서 탐색하다가
    // 최댓값이 아니면 다시 한 발짝 뒤로 물러선다고 생각하기.
    public static void dfs(int size, int depth) {
        // 계산하는 로직 (임시 배열에 값이 다 들어가있을 때)
        if(depth == size){
            int tempResult = 0;
            for(int i=0; i< temp.length-1; i++)
                tempResult += Math.abs(temp[i]-temp[i+1]);
            result = Math.max(result, tempResult);
            return;
        }
        /**
         * depth = 0
         * 20, 1, 15, ....
         * 5까지
         */

        // 0부터 반복문을 돌게 되면 어차피 visited 조건에 의해서
        // depth가 증가하더라도 탐색하는 위치는 계속 바뀌게 된다.
        for (int i = 0; i < size; i++) {
            // 방문하지 않았을 경우에
            if(!visited[i]){
                // 방문 표시
                visited[i] = true;

                // 임시 배열에 값 넣어주기
                temp[depth] = num[i];

                // depth를 증가해나가며 탐색
                dfs(size, depth + 1);

                // 다시 방문을 false로 처리하지 않으면 백트래킹 불가능.
                visited[i] = false;

            }
        }
    }
}
