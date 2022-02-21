package Level1;

import java.util.HashMap;

public class NotCompleteRace {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> race = new HashMap<String, Integer>();

        for(String player : participant) {
            // 동명이인이 존재하지 않는 경우
            if (race.get(player) == null)
                race.put(player, 1);
            else {
                // 기존에 동명이인이 존재하는 경우
                int count = race.get(player);
                race.put(player, count+1);
            }
        }


        for(String player : completion) {
            if (race.get(player) > 0) {
                // 일치하는 플레이어가 있는 경우 1명씩 제거
                int count = race.get(player) - 1;
                race.put(player, count);
            }
        }

        // 해시값 탐색 시 keySet() 사용하기
        for (String key : race.keySet()) {
            if (race.get(key) > 0)
                answer = key;
        }

        return answer;

    }
}
