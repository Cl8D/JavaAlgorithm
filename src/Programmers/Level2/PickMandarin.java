package Programmers.Level2;

import java.util.*;

// 귤 고르기
class PickMandarin {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> mandarin = new HashMap<>();

        for (int tan : tangerine) {
            mandarin.put(tan, mandarin.getOrDefault(tan, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(mandarin.keySet());
        keys.sort((o1, o2) -> {
            return mandarin.get(o2) - mandarin.get(o1);
        });

        int tempCount = 0;

        for (Integer key : keys) {
            tempCount += mandarin.get(key);
            answer++;
            if (tempCount >= k) {
                break;
            }
        }

        return answer;
    }

}