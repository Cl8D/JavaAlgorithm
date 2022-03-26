package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 회문문자열
public class _0107 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        // 대소문자 구분 x
        str = str.toLowerCase();

        StringBuilder sb;
        sb = new StringBuilder(str);

        if(str.equals(sb.reverse().toString()))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
