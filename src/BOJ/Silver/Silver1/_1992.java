package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쿼드트리
public class _1992 {
    static char[][] val;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        val = new char[n][n];
        for(int i=0; i<n; i++) {
            val[i] = buf.readLine().toCharArray();
        }

        recur(0, 0, n);
        System.out.println(answer);

    }

    static void recur(int x, int y, int size) {
        String temp = "";
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                temp += val[i][j];
            }
        }

        int half = size / 2;

        if(temp.contains("0") && temp.contains("1")) {
            answer+="(";
            recur(x, y, half);
            recur(x, y+half, half);
            recur(x+half, y, half);
            recur(x+half, y+half, half);
            answer += ")";

        }
        else {
            if (temp.contains("0"))
                answer += "0";
            else
                answer += "1";
        }

    }
}