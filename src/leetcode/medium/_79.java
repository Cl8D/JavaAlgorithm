package leetcode.medium;

// 79. Word Search
class _79 {
    private boolean[][] visited;
    private char[][] map;
    private String globalWord;

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private boolean answer = false;

    public boolean exist(char[][] board, String word) {
        globalWord = word;
        map = board;
        int n = board.length;
        int m = board[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[n][m];
                    visited[i][j] = true;
                    dfs(i, j, 1);
                    if (answer) {
                        return true;
                    }
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y, int target) {
        if (target == globalWord.length()) {
            answer = true;
            return;
        }

        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == globalWord.charAt(target)) {
                visited[nx][ny] = true;
                dfs(nx, ny, target+1);
                visited[nx][ny] = false;
            }
        }

    }
}
