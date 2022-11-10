package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// UCPC는 무엇의 약자일까?
public class _15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        String input = buf.readLine();

        // 공백 제거
        String removeStr = input.replaceAll(" ", "");

        // 각 문자에 대해 소문자 제거
        String newStr = removeStr.replaceAll("^[a-z]", "");

        int count = 0;
        for(Character c : newStr.toCharArray()) {
            if (count == 0 && c == 'U') {
                count++;
            }
            if (count == 1 && c == 'C') {
                count++;
            }
            if (count == 2 && c == 'P') {
                count++;
            }
            if (count == 3 && c == 'C') {
                count++;
            }
        }

        if (count == 4) {
            System.out.println("I love UCPC");
            return;
        }
        System.out.println("I hate UCPC");

        buf2.flush();
        buf.close();
        buf2.close();
    }
}