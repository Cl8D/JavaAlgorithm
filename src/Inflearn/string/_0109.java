package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 숫자만 추출
public class _0109 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        str = str.replaceAll("[^0-9]", "");

        StringBuilder sb;
        char[] cArr = str.toCharArray();

        int idx = 0;

        for(int i=0; i< cArr.length; i++) {
            if (cArr[i] != '0') {
                idx = i;
                break;
            }
        }

        sb = new StringBuilder(str);

        // delete는 idx-1까지 위치를 삭제한다.
        str = sb.delete(0, idx).toString();

        System.out.println(str);
    }
}
