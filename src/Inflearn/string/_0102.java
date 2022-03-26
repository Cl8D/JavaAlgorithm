package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 대소문자 변환
public class _0102 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        String result = "";

        for(char c : str.toCharArray()) {
            int ascii_c = (int) c;

            // 만약 대문자라면
            if(65 <= ascii_c && ascii_c <= 90)
                result += Character.toLowerCase(c);
                // 소문자라면
            else
                result += Character.toUpperCase(c);
        }

        System.out.println(result);
    }
}
