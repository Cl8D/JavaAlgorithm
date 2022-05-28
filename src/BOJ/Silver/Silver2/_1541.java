package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class _1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 반례) 00000-1+00000-00005 = 답 -6.
        // 초기 answer를 0으로 두고 첫 토큰이 answer==0인 경우로 잡았더니 첫 수가 0인 경우에 걸려버린다...!
        // 초기 answer 값은 다른 수로 두자!
        int answer = Integer.MAX_VALUE;
        String str = buf.readLine();
        // 뺄셈으로 1차적 분리
        String[] val = str.split("[-]");

        for(int i=0; i< val.length; i++) {
            // 분리된 애들 중에 덧셈으로 다시 분리, +가 없으면 수 그 자체가 나오게 된다.
            String[] split = val[i].split("[+]");
            int temp = 0;
            for (String sp : split) {
                temp += Integer.parseInt(sp);
            }
            // 분리된 첫 번째 애는 첫 번째 수니까 answer에 그대로, 아니면 빼주기!
            if(answer == Integer.MAX_VALUE)
                answer = temp;
            else
                answer -= temp;
        }

        System.out.println(answer);
    }
}

