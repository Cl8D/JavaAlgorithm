package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 합이 같은 부분집합 (DFS : 아마존 인터뷰) - 솔루션 코드
public class _0801S {
    static int[] val;
    static int n, total;
    static boolean flag = false;
    static String answer= "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        val = new int[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        total = Arrays.stream(val).sum();

        dfs(0, 0);

        System.out.println(answer);
    }

    // 합의 값을 계속 매개변수로 가지고 있는 형태
    static void dfs(int level, int sum){
        // flag가 true가 되면 더 이상 탐색하지 않도록 그냥 return 시키기
        if(flag)
            return;

        // 또한, sum이 total/2보다 커지면 굳이 더 계산할 필요 없으니까 return
        if(sum > total/2)
            return;

        if(level == n) {
            // 두 부분집합의 값이 같을 경우
            if((total-sum)==sum) {
                answer = "YES";
                flag = true;
            }
        }

        else {
            // 다음 원소를 부분집합으로 가지는 경우
            dfs(level+1, sum+val[level]);
            // 부분집합으로 가지지 않는 경우
            dfs(level+1, sum);
        }
    }
}