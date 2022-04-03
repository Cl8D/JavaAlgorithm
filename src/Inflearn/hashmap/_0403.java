package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3. 매출액의 종류
public class _0403 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];

        stk = new StringTokenizer(buf.readLine());

        // 값
        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        Map<Integer,Integer> map = new HashMap<>();

        int pt = 0;
        int first = val[pt++];
        for(int i=0; i<k; i++)
            map.put(val[i], map.getOrDefault(val[i], 0)+1);

        List<Integer> answer = new ArrayList<>();
        answer.add(map.size());

        for(int i=k; i<n; i++) {
            int first_key = first;
            int first_val = map.get(first_key);

            if(map.containsKey(first_key)) {
                map.remove(first_key);
                if(first_val > 1) {
                    for(int j=1; j<first_val; j++)
                        map.put(first_key, map.getOrDefault(first_key, 0)+1);
                }
            }
            map.put(val[i], map.getOrDefault(val[i], 0) + 1);
            first=val[pt++];
            answer.add(map.size());
        }

        for(int a : answer)
            System.out.print(a + " ");


    }
}
