package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 솔루션 코드의 경우 솔루션에서 도움이 될 것 같은 내용을 적는 용도!
 * 풀이랑 솔루션이랑 비슷하거나 이미 아는 내용이면 따로 솔루션 코드는 작성 X
 */

// 1. 문자 찾기 - 솔루션 코드
public class _0101S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        str = str.toLowerCase();

        int result = 0;

        char c = buf.readLine().charAt(0);
        c = Character.toLowerCase(c);

        // string을 문자 배열로 생성해주는 메서드
        for(char x : str.toCharArray()) {
            if (x == c)
                result++;
        }



        System.out.println(result);
    }
}
