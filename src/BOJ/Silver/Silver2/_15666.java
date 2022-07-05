package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// N과 M (12)
public class _15666 {
    static int n, m;
    static int[] input, val;
    static boolean[] visited;
    static Set<String> answer;

    // n개의! 자연수 중에서 m개를 고르는 수열
    // 중복되는 자연수가 들어올 수 있다.
    // 같은 수 여러 번 고를 수 있다 = 중복 가능!
    // 오름차순!

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        input = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            input[i] = Integer.parseInt(stk.nextToken());

        // 사전순으로 증가하는 수열을 만들기 위해서!
        Arrays.sort(input);

        visited = new boolean[n];
        val = new int[m];

        answer = new LinkedHashSet<>();

        dfs( 0, 0);

        // 기존의 문제와 다르게, 자연수에 중복되는 수가 들어올 수 있음.
        // 동일한 수여도 다르게 취급하지만, 수열로 만들어졌을 때 동일하면 안 되니까
        // 중복을 없애주기 위해서 수열을 Set에 넣어서 출력해주는 형태로 바꾸기!
        for(String s : answer)
            buf2.write(s);

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void dfs(int start, int level) {
        // 재귀의 깊이가 m과 같아지면, 탐색 과정에서 담았던 배열을 출력해주기
        if(level ==m) {
            StringBuilder ans = new StringBuilder("");
            for(int v : val) {
                ans.append(v).append(" ");
            }
            ans.append("\n");
            answer.add(ans.toString());
            return;
        }

        for(int i=start; i<n; i++) {
            val[level] = input[i];

            // 자식노드 방문
            dfs(i, level + 1);
        }

    }

}
