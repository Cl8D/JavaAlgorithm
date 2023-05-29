package leetcode.medium;

// 64. Minimum Path Sum
class _64 {
    private final int[] dx = {0, 1};
    private final int[] dy = {1, 0};
    private int[][] map;
    private int n, m, answer = Integer.MAX_VALUE;
    private int[][] visited;

    public int minPathSum(int[][] grid) {
        map = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        visited[0][0] = map[0][0];

        dfs(0, 0);
        return answer;
    }

    private void dfs(int x, int y) {
        if (x == n-1 && y == m-1) {
            answer = Math.min(answer, visited[x][y]);
            return;
        }

        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (visited[nx][ny] == 0 || visited[nx][ny] > visited[x][y] + map[nx][ny]) {
                visited[nx][ny] = visited[x][y] + map[nx][ny];
                dfs(nx, ny);
            }
        }
    }

    /** 시간 복잡도 고려하면 이렇게 푸는 게 더 좋을 것 같다. (dp를 제대로 활용하기) */
    public int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    visited[0][0] = grid[0][0];
                    continue;
                }
                int minSum = Math.min(calculate(visited, i - 1, j), calculate(visited, i, j - 1));
                visited[i][j] = minSum + grid[i][j];
            }
        }
        return visited[n-1][m-1];
    }

    private int calculate(int[][] grid, int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        return grid[i][j];
    }
}
