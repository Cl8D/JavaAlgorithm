package Programmers.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 압축
public class StringCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        int minLength = 1001;

        // 문자의 길이가 1 이상일 때.
        if (str.length() > 1) {
            for (int n = 1; n < str.length() / 2; n++) {
                str += " ";

                // ababcdcdababcdcd
                // i=0,2,4..
                // 만약 n=2
                // ab ab cd cd ab ab cd cd
                // 0~1 2~3 4~5 6~7 8~9 10~11 12~13 14~15
                // 결과) 2ab2cd2ab2cd

                String result = "";
                int count = 1;

                for (int i = 0; i < str.length() - n; i += n) {
                    // i~ i+n-1까지 잘라내기
                    // temp = ab, ab...
                    String temp = str.substring(i, i + n);

                    // 그리고 그 다음 위치 잘라내기 - 단, 인덱스 범위 안 넘도록 끝쪽이면 그 다음 위치 자르기 x
                    // nextTemp = ab, cd...
                    if (i + n < str.length() - n) {
                        String nextTemp = str.substring(i + n, i + n + n);
                        if (temp.equals(nextTemp)) {
                            count++;
                        } else {
                            if (count > 1)
                                result += String.valueOf(count);
                            result += temp;
                            count = 1;
                        }
                    }
                    // 마지막 문자에 대해 따로 처리
                    else {
                        if (count > 1)
                            result += count;
                        result += temp;
                    }
                }
                result = result.replaceAll(" ", "");
                minLength = Math.min(minLength, result.length());
            }
        }
        else {
            minLength = 1;
        }

        System.out.println(minLength);

    }
}
