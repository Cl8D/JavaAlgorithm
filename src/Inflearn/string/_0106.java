package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

// 6. 중복 문자 제거
public class _0106 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        char[] cArr = str.toCharArray();

        // 순서를 보장하는 map. 순서대로 넣고, 출력하고 싶을 때 사용하면 좋다
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        int idx = 0;
        for(char c : cArr) {
            map.put(c, idx);
            idx++;
        }

        for(char key: map.keySet()) {
            System.out.print(key);
        }
    }
}
