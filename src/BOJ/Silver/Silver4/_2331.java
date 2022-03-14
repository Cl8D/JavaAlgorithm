package BOJ.Silver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int a = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> perm = new HashMap();
        int key = 0;
        perm.put(key, a);
        int result = 0;

        while(true) {
            int prev = perm.get(key);
            String str_prev = Integer.toString(prev);
            String[] prevArray = str_prev.split("");

            int val = 0;

            for(String pr : prevArray) {
                val += Math.pow(Integer.parseInt(pr), p);
            }

            // 만약 map에 해당 value를 이미 가지고 있다면,
            // value에 해당하는 key 값 리턴
            if(perm.containsValue(val)) {
                for(Integer k: perm.keySet()) {
                    if(perm.get(k) == val)
                        result = k;
                }
                break;
            }
            key++;
            perm.put(key, val);
        }

        System.out.println(result);

    }
}
