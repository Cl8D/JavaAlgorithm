package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 문자 찾기
public class _0101 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        str = str.toLowerCase();
        String c = buf.readLine();
        c = c.toLowerCase();

        int result = 0;

        String[] str_arr = str.split("");
        for(String s : str_arr) {
            if (s.equals(c))
                result++;
        }

        System.out.println(result);
    }
}
