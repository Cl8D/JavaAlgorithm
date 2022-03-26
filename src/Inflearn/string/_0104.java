package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. 단어 뒤집기
public class _0104 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        for(int i=0; i<n; i++) {
            String str = buf.readLine();
            String[] s_arr = str.split("");
            String result = "";

            for(int j=str.length()-1; j>=0; j--) {
                result += s_arr[j];
            }

            /**
             * 아니면, 인덱스를 활용해서 서로 자리를 바꿔주는 방법도 있다.
             * 근데 이거는 너무 복잡해 보여서 아마 안 쓸 것 같다
             * 시작 위치, 끝 위치를 바꿔주면서 앞쪽으로 오면서 중간에서 만나는 방법.
             *
             * char[] cArr = str.toCharArray();
             * int lt =0;
             * int rt = str.length() -1;
             *
             * while(lt < rt) {
             *      char tmp = cArr[lt];
             *      cArr[lt] = cArr[rt];
             *      cArr[rt] = tmp;
             *      lt++;
             *      rt--;
             * }
             */

            System.out.println(result);
        }
    }
}
