package BOJ.Silver.Silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜
public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for(int i=1; i<=n; i++) {
            String monster = buf.readLine();
            map.put(monster, i);
            map2.put(i, monster);
        }
        for(int i=0; i<m; i++) {
            String find = buf.readLine();
            Integer result = map.getOrDefault(find, -1);
            if(result==-1)
                buf2.write(map2.get(Integer.parseInt(find)) + "\n");
            else
                buf2.write(result + "\n");
        }
        // 몰랐는데 flush는 마지막에 한 번 해주는 거였음.........ㅎㅎㅎ
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
