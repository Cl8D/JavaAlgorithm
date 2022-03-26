package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 숫자만 추출 - 솔루션 코드
public class _0109S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        StringBuilder sb;
        char[] cArr = str.toCharArray();

        int answer = 0;

        // 아스키코드를 사용한 풀이법
        for(char c : cArr) {
            // 0(48)~9(57) 사이의 값만
            if (c >= 48 && c <= 57)
                // 자연수값을 구하기 위해 *10
                // 아스키에서 실제 숫자값을 구하기 위해 48을 빼주기
                answer = answer*10 + (c-48);
        }

        // 아니면, 숫자인지 확인하는 것도 있음
        // Character.isDigit(x)

        // 그리고, 0208 이런 식으로 있을 때 자연수값으로 리턴하려면
        // 그냥 Integer.parseInt(str)을 사용해도 된다!
        // 이러면 알아서 208로 리턴해줌!
        System.out.println(answer);
    }
}
