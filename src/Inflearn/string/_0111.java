package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 11. 문자열 압축
public class _0111 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        List<Character> charc = new ArrayList<>();
        List<Integer> icount = new ArrayList<>();

        char temp = str.charAt(0);
        charc.add(temp);

        int count = 0;

        for(char c : str.toCharArray()) {
            if(temp == c) {
                count++;
            }
            else {
                temp = c;
                charc.add(temp);
                icount.add(count);
                count = 1;
            }
        }

        // 마지막 순서에 있는 문자에 대해서도 처리해주기
        icount.add(count);

        for(int i=0; i<charc.size(); i++) {
            System.out.print(charc.get(i));
            if(icount.get(i) != 1)
                System.out.print(icount.get(i));
        }


    }
}
