package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9375 {
    public static void main(String[] args) throws IOException {

        // 입출력을 더 빠르게 하기 위해
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        // buf.readLine()의 반환형은 String
        int t = Integer.parseInt(buf.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(buf.readLine());
            Map<String, String> map = new HashMap<>();

            for(int j = 0; j< n; j++) {
                // stringTokenizer는 공백 단위로 문자 구분이 가능하다.
                StringTokenizer stk = new StringTokenizer(buf.readLine());
                String str1 = stk.nextToken();
                String str2 = stk.nextToken();


                map.put(str1, str2);
            }

            // 옷을 종류별로 구분하자.
            HashMap<String, Integer> map2 = new HashMap<>();

            for(String key: map.keySet()) {
                String clothType = map.get(key);

                // 이때 해시맵을 사용할 때 map.getOrDefault(key, 0)을 사용하였는데
                // 이는 key값에 해당하는 value가 있으면 가져오고, 아니면 0을 리턴해주는 함수라고 한다.
                // 여기서는, 옷의 종류 값을 key 값으로 둔 다음에,
                // 해당 옷이 존재하지 않는다면 0으로 설정하고
                // 옷이 존재한다면 기존의 값 + 1을 해주는 형태로 설계하였다.

                map2.put(clothType, map2.getOrDefault(clothType, 0) + 1);
            }

            // 입지 않는 경우를 추가하여 모든 경우 계산하기
            // 여기서 iterator를 사용하면 성능 개선된다는 점 생각하기!
            Iterator<Integer> iter = map2.values().iterator();

            int answer = 1;

            while(iter.hasNext())
                answer *= iter.next().intValue() + 1;

            System.out.println(answer-1);
        }
    }

}
