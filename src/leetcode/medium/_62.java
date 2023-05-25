package leetcode.medium;

// 62. Unique Paths
// 다시 풀어봐도 좋을 것 같다.
class _62 {

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        // 역으로 탐색
        return search(m-1, n-1, map);
    }

    private int search(int x, int y, final int[][] map) {
        if (x == 0 || y == 0) {
            return 1;
        }
        // 경우의 수가 이미 존재하기 때문에 패스
        if (map[x][y] > 0) {
            return map[x][y];
        }
        // 이전까지의 경우의 수의 합으로 구현
        return map[x][y] = search(x-1, y, map) + search(x, y-1, map);
    }
}
