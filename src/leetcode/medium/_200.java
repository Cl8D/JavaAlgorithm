package leetcode.medium;

// 200. Number of Islands
class _200 {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y, char[][] grid) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == '0') {
                continue;
            }
            grid[nx][ny] = '0';
            dfs(nx, ny, grid);
        }
    }
}
