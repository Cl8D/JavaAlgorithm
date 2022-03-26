package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12. 암호 - 솔루션 코드
public class _0112S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        String str = buf.readLine();

        String result = "";

        // subString + replace 활용하기
        for(int i=0; i<n; i++) {
            // 0~6까지 잘라내기
            // 그리고 replace를 통해서 바꿔주기!
            String tmp = str.substring(0, 7)
                    // 이런 식으로 탐색해서 바꿔주는 게 좋을 듯!!
                    .replace('#', '1')
                    .replace('*', '0');

            int num = Integer.parseInt(tmp, 2);
            // string에 그냥 char형 바로 붙여도 되는구나...
            result += (char)num;

            // 7 이후 값을 잘라내서 str 값 갱신하기
            str = str.substring(7);
        }

        System.out.println(result);
    }
}
