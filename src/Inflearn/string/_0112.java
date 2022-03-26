package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12. 암호
public class _0112 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        String str = buf.readLine();

        char[] cArr = str.toCharArray();

        String result = "";

        for(int i=0; i<n; i++) {
            String temp = "";
            int idx = 7*i;
            // 0 -> 0~6 / 1 -> 7~13...

            for(int j=0; j<7; j++) {
                if(cArr[idx+j] == '#')
                    temp += "1";
                else
                    temp += "0";
            }

            int itemp = Integer.parseInt(temp, 2);
            char ctemp = (char) itemp;
            result += String.valueOf(ctemp);
        }

        System.out.println(result);

    }
}
