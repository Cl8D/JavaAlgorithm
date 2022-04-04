package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 4. 모든 아나그램 찾기
public class _0404 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        char[] c1 = buf.readLine().toCharArray();
        char[] c2 = buf.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : c2)
            map2.put(c, map2.getOrDefault(c, 0) + 1);

        // 초기값 설정하기
        for(int i=0; i<c2.length-1; i++)
            map.put(c1[i], map.getOrDefault(c1[i], 0)+1);

        int lt = 0;
        int count = 0;
        for(int rt=c2.length-1; rt<c1.length; rt++) {
            map.put(c1[rt], map.getOrDefault(c1[rt], 0)+1);
            // map의 구성 요소 동일한지 판단할 때 equals 사용
            if(map.equals(map2))
                count++;

            map.put(c1[lt], map.get(c1[lt])-1);
            if(map.get(c1[lt]) == 0)
                map.remove(c1[lt]);
            lt++;
        }
        System.out.println(count);

    }

}
