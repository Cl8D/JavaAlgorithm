package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3. 매출액의 종류 - 솔루션 코드
public class _0403S {
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
        List<Integer> answer = new ArrayList<>();

        // 해시맵에 초기값 설정
        for(int i=0; i<k-1; i++) {
            map.put(val[i], map.getOrDefault(val[i], 0) + 1);
        }
        // two points
        // rt는 window에 값을 추가하는 용도, lt는 window에 가장 앞에 있는 값을 빼주는 용도.
        int lt = 0;
        for(int rt=k-1; rt<n; rt++) {
            map.put(val[rt], map.getOrDefault(val[rt], 0) + 1);
            answer.add(map.size());
            // map에서 값을 빼주는 용도.
            map.put(val[lt], map.get(val[lt])-1);
            // 값을 하나 제거했을 때 value값이 0이라면
            // 이는 곧 window 내에 값이 존재하지 않음을 의미한다.
            if(map.get(val[lt]) == 0)
                map.remove(val[lt]);
            lt++;
        }

        for(int a : answer)
            System.out.print(a + " ");

    }
}
