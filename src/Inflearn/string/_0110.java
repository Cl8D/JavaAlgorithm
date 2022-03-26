package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 10. 문자 거리
public class _0110 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        String str = stk.nextToken();
        String t = stk.nextToken();

        List<Integer> idxArr = new ArrayList<>();

        String[] sArr = str.split("");

        for(int i=0; i< sArr.length; i++) {
            if (sArr[i].equals(t)) {
                idxArr.add(i);
            }
        }

        for(int i=0; i<str.length(); i++) {
            int min = 101;
            int temp = 0;

            for(int j=0; j<idxArr.size(); j++) {
                temp = i - idxArr.get(j);
                temp = Math.abs(temp);

                if(temp < min)
                    min = temp;
            }
            System.out.print(min + " ");
        }
    }
}
