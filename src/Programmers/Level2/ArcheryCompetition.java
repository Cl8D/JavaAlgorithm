package Programmers.Level2;

import java.util.*;

// 양궁대회
class ArcheryCompetition {
    static int[] ryanScore, apeachScore;
    static int attackCount = 0, maxDiffScore = -1;
    static final int MAX_SCORE = 10;
    // 점수 기록 보관
    static ArrayList<int[]> ryanScores = new ArrayList<int[]>();

    public int[] solution(int n, int[] info) {
        // 라이언이 가장 큰 점수 차이로 우승하기 위해 어떤 과녁에 맞혀야 하는지
        // 여러 가지면 가장 낮은 점수를 더 많이 맞힌 경우를 리턴.
        // 지거나 비기면 [-1]
        int[] answer = {};

        apeachScore = info;
        ryanScore = new int[info.length];
        attackCount = n;

        // n -> 어피치가 쏜 화살의 개수
        // + 라이언이 쏠 화살의 개수
        // info -> 어피치가 맞힌 과녁 점수의 개수 (10~0), length = 11
        dfs(0, 0);

        // 라이언 점수가 더 큰 경우가 없다면
        if (maxDiffScore == -1) {
            return new int[]{-1};
        }

        // 가장 낮은 점수를 더 많이 맞힌 경우 리턴해오기.
        // 내림차순으로 정렬 진행.
        ryanScores.sort((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });

        return ryanScores.get(0);
    }

    // 범위가 작기 때문에 완전 탐색 가능.
    private void dfs(int level, int start) {
        // 화살 개수만큼 쏜 경우 점수 비교 진행
        if (level == attackCount) {
            int ryanTotalScore = 0;
            int apeachTotalScore = 0;

            for (int i=0; i<=MAX_SCORE; i++) {
                // 둘 다 0이면 점수 안 먹음
                if (ryanScore[i] == 0 && apeachScore[i] == 0) {
                    continue;
                }
                // 어피치가 더 크거나 같을 경우 어피치가 먹음
                if (apeachScore[i] >= ryanScore[i]) {
                    apeachTotalScore += (MAX_SCORE - i);
                } else {
                    ryanTotalScore += (MAX_SCORE - i);
                }
            }

            // 만약 라이언의 점수가 더 크다면
            if (ryanTotalScore > apeachTotalScore) {
                // 두 점수의 차이를 구해서 가장 큰 차이 구하기
                int diffScore = ryanTotalScore - apeachTotalScore;
                if (diffScore > maxDiffScore) {
                    maxDiffScore = diffScore;
                    // 점수 기록 초기화
                    ryanScores.clear();
                    // 점수 기록 넣어주기.
                    ryanScores.add(ryanScore.clone());
                }
                // 만약 갱신이 아니라 동일하다면 리스트에 넣어두기.
                // 추후 결과맵에서 빼서 낮은 점수가 더 많은 애를 답으로 체크.
                if (diffScore == maxDiffScore) {
                    ryanScores.add(ryanScore.clone());
                }
            }
            return;
        }

        // 모든 경우에 대해서 탐색
        for (int i=start; i<=MAX_SCORE; i++) {
            ryanScore[i]++;
            dfs(level + 1, i);
            ryanScore[i]--;
        }
    }

}