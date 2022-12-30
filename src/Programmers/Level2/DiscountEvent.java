package Programmers.Level2;

import java.util.*;

// 할인 행사
class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // want -> 원하는 제품
        // number -> 원하는 제품 수량
        // discount -> 할인 제품 문자열
        Map<String, Integer> product = new HashMap<>();

        for (int i=0; i<want.length; i++) {
            product.put(want[i], number[i]);
        }

        // 0 ~ 10번까지
        for (int i=0; i<10; i++) {
            String dis = discount[i];
            if (!product.containsKey(dis)) {
                continue;
            }
            int count = product.get(dis) - 1;
            product.put(dis, count);
        }

        // 검증
        if (validateCount(product)) {
            answer++;
        }

        // 슬라이딩 윈도우
        for (int i=1; i<discount.length-9; i++) {
            // 이전 값을 가져와서 다시 +1을 해주고 넣어준다.
            String prev = discount[i-1];
            if (product.containsKey(prev)) {
                int count = product.get(prev) + 1;
                product.put(prev, count);
            }

            // 마지막 값을 가져와서 -1을 해주고 넣어준다.
            String next = discount[9 + i];
            if (product.containsKey(next)) {
                int nextCount = product.get(next) - 1;
                product.put(next, nextCount);
            }

            if(validateCount(product)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean validateCount(Map<String, Integer> product) {
        for (String key : product.keySet()) {
            if (product.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}