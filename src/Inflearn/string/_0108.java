package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0108 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        StringBuilder sb;

        str = str.replaceAll("[^a-zA-Z]", "");
        str = str.toLowerCase();

        sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();

        if(str.equals(reverse))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
