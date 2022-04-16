
import java.io.*;
import java.util.*;

public class Main {
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        dfs(n);
        System.out.println(answer);
    }

    static void dfs(int n) {
        if(n==0)
            return;
        else {
            dfs(n-1);
            answer *= n;
        }
    }
}

