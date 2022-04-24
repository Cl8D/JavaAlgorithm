
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 1~n까지 적힌 구슬에서 중복 허락, m번 뽑아서 일렬 나열
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

    }

    static void dfs(int val) {
        if(val == m) {

        }
        else {
            dfs(val+1)
        }
    }


}