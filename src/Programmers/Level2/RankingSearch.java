package Programmers.Level2;

import java.util.*;

// 순위 검색 - 100점!
class RankingSearch {
    private static Map<BaseInfo, List<Integer>> userInfos = new HashMap<>();
    private static StringTokenizer stk;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int answerIdx = 0;

        // 개발언어: cpp, java, python
        // 지원직군: backend, frontend
        // 지원 경력구분: junior, senior
        // 소울푸드: chicken, pizza

        // info -> 4가지 정보, 코딩테스트 점수 배열
        // query -> 문의 조건
        // * [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?

        for (String userInfo : info) {
            stk = new StringTokenizer(userInfo);
            String language = stk.nextToken();
            String course = stk.nextToken();
            String career = stk.nextToken();
            String soulFood = stk.nextToken();
            Integer score = Integer.parseInt(stk.nextToken());

            createAllCase(language, course, career, soulFood, score);
        }

        for (BaseInfo userInfo : userInfos.keySet()) {
            Collections.sort(userInfos.get(userInfo));
        }

        for (String userQuery : query) {
            stk = new StringTokenizer(userQuery);
            String language = getInfo(false);
            String course = getInfo(false);
            String career = getInfo(false);
            String soulFood = getInfo(true);
            Integer standardScore = Integer.parseInt(stk.nextToken());

            BaseInfo standardInfo = new BaseInfo(language, course, career, soulFood);
            List<Integer> standardScores = userInfos.get(standardInfo);
            if (standardScores == null) {
                answer[answerIdx++] = 0;
                continue;
            }
            answer[answerIdx++] = findGEScores(standardScores, standardScore);
        }

        return answer;
    }

    private String getInfo(boolean last) {
        String info = stk.nextToken();
        if (!last) {
            stk.nextToken();
        }
        return info;
    }

    // 나올 수 있는 경우의 수 [ABCD]
    // ----
    // A--- -B-- --C- ---D
    // AB-- A-C- A--D -BC- -BD- --CD
    // ABC- AB-D A-CD -BCD
    // ABCD
    private void createAllCase(String language, String course, String career, String soulFood, Integer score) {
        getAndAddScore(new BaseInfo("-", "-", "-", "-"), score);

        getAndAddScore(new BaseInfo(language, "-", "-", "-"), score);
        getAndAddScore(new BaseInfo("-", course, "-", "-"), score);
        getAndAddScore(new BaseInfo("-", "-", career, "-"), score);
        getAndAddScore(new BaseInfo("-", "-", "-", soulFood), score);

        getAndAddScore(new BaseInfo(language, course, "-", "-"), score);
        getAndAddScore(new BaseInfo(language, "-", career, "-"), score);
        getAndAddScore(new BaseInfo(language, "-", "-", soulFood), score);
        getAndAddScore(new BaseInfo("-", course, career, "-"), score);
        getAndAddScore(new BaseInfo("-", course, "-", soulFood), score);
        getAndAddScore(new BaseInfo("-", "-", career, soulFood), score);

        getAndAddScore(new BaseInfo(language, course, career, "-"), score);
        getAndAddScore(new BaseInfo(language, "-", career, soulFood), score);
        getAndAddScore(new BaseInfo(language, course, "-", soulFood), score);
        getAndAddScore(new BaseInfo("-", course, career, soulFood), score);

        getAndAddScore(new BaseInfo(language, course, career, soulFood), score);
    }

    private void getAndAddScore(BaseInfo standardInfo, Integer score) {
        List<Integer> scores = userInfos.getOrDefault(standardInfo, new ArrayList<>());
        scores.add(score);
        userInfos.put(standardInfo, scores);
    }

    private int findGEScores(List<Integer> standardScores, int score) {
        int start = 0, end = standardScores.size()-1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (standardScores.get(middle) < score) {
                start = middle + 1;
                continue;
            }
            end = middle - 1;
        }

        return standardScores.size() - start;
    }

    private static class BaseInfo {
        private String language;
        private String course;
        private String career;
        private String soulFood;

        public BaseInfo(String language, String course, String career, String soulFood) {
            this.language = language;
            this.course = course;
            this.career = career;
            this.soulFood = soulFood;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BaseInfo baseInfo = (BaseInfo) o;
            return Objects.equals(language, baseInfo.language) && Objects.equals(course, baseInfo.course) && Objects.equals(career, baseInfo.career) && Objects.equals(soulFood, baseInfo.soulFood);
        }

        @Override
        public int hashCode() {
            return Objects.hash(language, course, career, soulFood);
        }
    }
}