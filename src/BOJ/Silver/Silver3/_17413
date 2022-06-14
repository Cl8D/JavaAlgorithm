package BOJ.Silver.Silver3;

import java.io.*;
import java.util.StringTokenizer;

// 단어 뒤집기
public class _17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String input = buf.readLine();
        input += " "; // 마지막까지 처리하기 위해 끝에 공백 추가

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean check = false;

        for(char c : input.toCharArray()) {
            if(c=='<') {
                result.append(temp.reverse());
                temp.delete(0, temp.length());
                result.append('<');
                check = true;
            }
            else if(c=='>') {
                result.append('>');
                check = false;
            }
            else if(c==' ') {
                if(!temp.equals("")) {
                    result.append(temp.reverse());
                    temp.delete(0, temp.length());
                }
                result.append(' ');
            }
            else {
                if(check)
                    result.append(c);
                else {
                    temp.append(c);
                }
            }
        }


        System.out.println(result);


    }
}
