package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. 단어 뒤집기 - 솔루션 코드
public class _0104S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        // stringBuilder 이용해서 문자열 뒤집기
        StringBuilder sb;

        for(int i=0; i<n; i++) {
            String str = buf.readLine();
            sb = new StringBuilder(str);
            // 이런 식으로 reverse나 여러 가지 가능...
            // string은 원래 불변 객체인데, 기존의 객체를 그대로 사용해서 속도가 빠름!
            System.out.println(sb.reverse().toString());
        }
    }
}
