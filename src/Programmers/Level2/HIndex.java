package Programmers.Level2;

import java.util.*;

// H-Index
class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        // https://school.programmers.co.kr/questions/41463
        // 여기를 봐야 이해가 좀 된다... ㅠ

        // 0 1 3 5 6 8
        for (int i=0; i<citations.length; i++) {
            // i보다 인용 횟수가 같거나 큰 논문의 개수
            // h-index의 최댓값을 구해야 하니까, 같거나 큰 논문의 개수를 기준으로 잡는다.
            int count = citations.length - i;
            if (citations[i] >= count) {
                return count;
            }
        }

        return 0;
    }
}