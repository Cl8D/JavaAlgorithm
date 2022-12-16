package Programmers.Level1;

import java.util.*;

// 실패율
class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] userStage = new int[N + 2];
        int[] successUser = new int[N + 1];

        // n -> 전체 스테이지의 수, stages -> 사용자의 현재 멈춰있는 스테이지 번호
        // answer -> 실패율이 높인 스테이지부터 내림차순으로.
        // 실패율 = 클리어 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수

        // {0, 1, 3, 2, 1, 0, 1, 0}
        // 각 스테이지에 머물러 있는 사람의 수.
        for (int stage : stages) {
            userStage[stage]++;
        }

        // {0, 0, 0, 0, 0, 1}
        // 마지막 스테이지 도달
        successUser[N] = userStage[N] + userStage[N + 1];

        // {0, 8, 7, 4, 2, 1}
        // 스테이지에 도달한 플레이어의 수
        for (int i = N - 1; i >= 1; i--) {
            successUser[i] = userStage[i] + successUser[i + 1];
        }

        List<Failure> failStatus = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            // 도달한 유저가 없다면 실패율 0.
            if (successUser[i] == 0) {
                failStatus.add(new Failure(i, 0));
                continue;
            }
            double failure = (double) userStage[i] / successUser[i];
            failStatus.add(new Failure(i, failure));
        }

        // 내림차순으로 정렬
        failStatus.sort((o1, o2) -> {
            if (o1.failure == o2.failure) {
                return o1.stage - o2.stage;
            }
            if (o1.failure < o2.failure) {
                return 1;
            }
            return -1;
        });

        for (int i = 0; i < failStatus.size(); i++) {
            answer[i] = failStatus.get(i).stage;
        }

        return answer;
    }

    static class Failure {
        int stage;
        double failure;

        public Failure(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }

        @Override
        public String toString() {
            return stage + " " + failure;
        }
    }

}