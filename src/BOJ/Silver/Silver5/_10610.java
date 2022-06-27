package BOJ.Silver.Silver5;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 30
public class _10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String[] chars = buf.readLine().split("");
        // 내림차순으로 정렬해주기 (애초에 하나씩 비교하는 건 안 될 것 같음! N이 너무 커서)
        Arrays.sort(chars, Collections.reverseOrder());

        // 마지막 수가 0으로 끝나야 하고, 3의 배수니까 더한 값이 3으로 나눠져야 함
        if(!chars[chars.length-1].equals("0"))
            buf2.write("-1");
        else {
            // 3의 배수인지 체크
            StringBuilder value = new StringBuilder();
            BigInteger integer = new BigInteger("0");
            for(String s : chars) {
                integer = integer.add(new BigInteger(s));
                value.append(s);
            }
            if(integer.remainder(new BigInteger("3")).toString().equals("0"))
                buf2.write(value.toString());
            else
                buf2.write("-1");
        }

        buf2.flush();
        buf.close();
        buf2.close();
    }

}
