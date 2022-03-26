package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 문장 속 단어
public class _0103 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        String[] strArr = str.split(" ");

        String result = "";
        int maxLength = 0;

        for(String s : strArr) {
            if (maxLength < s.length()) {
                maxLength = s.length();
                result = s;
            }
        }

        System.out.println(result);

    }
}
