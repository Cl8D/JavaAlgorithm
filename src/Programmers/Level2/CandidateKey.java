package Programmers.Level2;

import java.util.*;

// 후보키
class CandidateKey {
    private static boolean[] visited;
    private static String[][] relations;
    private static List<String> values, alreadyUsed;
    private static int candidateCount = 0;


    public int solution(String[][] relation) {
        int answer = 0;
        relations = relation;

        alreadyUsed = new ArrayList<>();

        for (int i=0; i<relation.length; i++) {
            String number = relation[i][0];
            String name = relation[i][1];
            String major = relation[i][2];
            String grade = relation[i][3];
        }

        for (int i=1; i<=relation[0].length; i++) {
            visited = new boolean[relation[0].length];
            dfs(0, i, 0);
        }

        answer = candidateCount;
        return answer;
    }

    // 가능한 조합을 뽑아내기.
    private void dfs(int depth, int n, int start) {
        if (depth == n) {
            StringBuilder indexes = new StringBuilder("");
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    indexes.append(i);
                }
            }
            String[] index = indexes.toString().split("");

            if (isUniqueKey(index) && isCandidateKey(index)) {
                candidateCount++;
            }
            return;
        }

        for (int i=start; i<relations[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, n, i+1);
                visited[i] = false;
            }
        }
    }

    // 유일키인지 판단
    private boolean isUniqueKey(String[] index) {
        values = new ArrayList<>();
        boolean flag = false;

        for (int i=0; i<relations.length; i++) {
            StringBuilder tuple = new StringBuilder("");
            for (int j=0; j<index.length; j++) {
                int idx = Integer.parseInt(index[j]);
                tuple.append(relations[i][idx]).append("#");
            }

            if (values.contains(tuple.toString())) {
                flag = true;
                break;
            }
            values.add(tuple.toString());
        }

        if (flag) {
            return false;
        }

        return true;
    }

    // 후보키인지 판단
    private boolean isCandidateKey(String[] index) {
        String idxKey = String.join("", index);

        for (String used : alreadyUsed) {
            if (idxKey.contains(used)){
                return false;
            }
        }

        alreadyUsed.add(idxKey);
        return true;
    }
}


