package Programmers.Level2;

class DegreeFatigue {
    private static boolean[] visited;
    private static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        return answer;
    }

    private void dfs(int level, int[][] dungeons, int current) {
        for(int i=0; i<dungeons.length; i++) {
            // 현재 피로도가 최소 필요 피로도보다 커야 한다.
            if (!visited[i] && dungeons[i][0] <= current) {
                visited[i] = true;
                // 소모 피로도 빼주기
                dfs(level+1, dungeons, current - dungeons[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, level);
    }

}