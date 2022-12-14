package Programmers.Level1;

import java.util.*;

// 로또의 최고 순위와 최저 순위
class LottoNumHighLow {
    // 1-> 6개, 2-> 5개, 3->4개, 4->3개, 5->2개, 6->그외
    private static final int standardNum = 7;

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> winNums = new ArrayList<>();
        for (int winNum : win_nums) {
            winNums.add(winNum);
        }


        int zeroCount = 0;
        int matchCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            if (winNums.contains(lotto)) {
                matchCount++;
            }
        }
        int maxRank = standardNum - (matchCount + zeroCount);
        int minRank = standardNum - matchCount;

        if (minRank >= standardNum) {
            minRank = 6;
        }

        // 전부 낙첨일 경우 maxRank도 6 이상의 값이 나올수도 있다.
        if (maxRank >= standardNum) {
            maxRank = 6;
        }

        // 최고 순위
        answer[0] = maxRank;
        // 최저 순위
        answer[1] = minRank;

        return answer;
    }
}