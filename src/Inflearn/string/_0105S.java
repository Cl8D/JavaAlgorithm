package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 5. 특정 문자 뒤집기 - 솔루션 코드
public class _0105S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        char[] cArr = str.toCharArray();
        // 인덱스를 이용한 풀이
        // lt, rt에 있는 값이 알파벳이면 바꾸고,
        // 아니라면 그냥 값을 증가/감소 시켜주기.

        int lt = 0, rt = str.length()-1;
        while(lt<rt) {
            // lt에 있는 값이 알파벳이 아니라면
            if(!Character.isAlphabetic(cArr[lt]))
                lt++;
            else if(!Character.isAlphabetic(cArr[rt]))
                rt--;
            else {
                char tmp = cArr[lt];
                cArr[lt] = cArr[rt];
                cArr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String result = String.valueOf(cArr);
        System.out.println(result);

    }
}
