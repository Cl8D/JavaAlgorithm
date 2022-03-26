package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 대소문자 변환 - 솔루션 코드
public class _0102S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        String result = "";


        for(char c : str.toCharArray()) {
            // 아스키코드 대신에 그냥 if문 조건으로 해결하는 방법
            if (Character.isLowerCase(c))
                result += Character.toUpperCase(c);
            else
                result += Character.toLowerCase(c);
        }

        System.out.println(result);
    }
}
