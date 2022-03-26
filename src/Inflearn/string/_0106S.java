package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

// 6. 중복 문자 제거 - 솔루션 코드
public class _0106S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        String result = "";

        // indexOf을 사용한 풀이
        for(int i=0; i< str.length(); i++) {
            // 만약, 현재 위치에 있는 해당 문자(str.charAt(i)의
            // 최초로! 나온 인덱스의 값 (str.indexOf)이
            // 현재 위치와 동일하다면,
            // 이는 곧 처음으로 나왔다는 의미이다. (다르다면 이미 이전에 나왔음을 의미하는 것이니까)
            if(str.indexOf(str.charAt(i)) == i)
                result += str.charAt(i);
        }

        System.out.println(result);
    }
}
