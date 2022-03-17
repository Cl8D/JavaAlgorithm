package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 {
    static int n, m;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        temp = new int[m];

        dfs(0, 0);

    }

    public static void dfs(int start, int depth) {

        if(depth == m) {
            for(int t : temp)
                System.out.print(t + " ");
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++) {
            temp[depth] = i+1;
            dfs(i+1, depth+1);
        }
    }
}
