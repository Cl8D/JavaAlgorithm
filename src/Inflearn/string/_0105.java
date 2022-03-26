package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 5. 특정 문자 뒤집기
public class _0105 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        char[] cArr = str.toCharArray();

        String temp = "";
        StringBuilder sb;

        List<Integer> spec_idx = new ArrayList<>();
        List<Character> spec = new ArrayList<>();

        for(int i=0; i<cArr.length; i++) {
            if(Character.isLowerCase(cArr[i]) || Character.isUpperCase(cArr[i]))
                temp += String.valueOf(cArr[i]);
            else {
                spec_idx.add(i);
                spec.add(cArr[i]);
            }
        }

        sb = new StringBuilder(temp);
        temp = sb.reverse().toString();
        sb = new StringBuilder(temp);

        for(int i=0; i< spec.size(); i++) {
            int idx = spec_idx.get(i);
            char sp = spec.get(i);
            sb.insert(idx, sp);
        }

        System.out.println(sb);

    }
}
