package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 달팽이는 올라가고 싶다
public class _2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken());

        // 단순 반복문으로 풀면 무조건 시간 초과가 나기 때문에 수식을 세워서 풀어야 한다.
        // 정상에 도달하면 미끄러지지 않는다.
        int day = (v-b) / (a-b);

        // 달팽이가 딱 맞게 올라간다면 괜찮지만, 미끄러지고 나서 올라갈 거리가 남아있을 수 있기 때문에
        // 다음날에 올라가야 하기 때문에 ++를 해준다.
        if((v-b) % (a-b) != 0)
            day++;

        buf2.write(day+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
