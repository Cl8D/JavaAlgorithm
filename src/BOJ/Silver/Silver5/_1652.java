package BOJ.Silver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 누울 자리를 찾아라
public class _1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buf.readLine());
        int width = 0, height = 0;

        char[][] values = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = buf.readLine();
            for (int j = 0; j < n; j++) {
                values[i][j] = str.charAt(j);
            }
        }

        // 가로
        for (int i = 0; i < n; i++) {
            int w = 0, h = 0;
            for (int j = 0; j < n; j++) {
                // 가로 체크
                if (values[i][j] == '.') {
                    w++;
                }
                if (values[i][j] == 'X' || j == n - 1) {
                    if (w >= 2) {
                        width++;
                    }
                    w = 0;
                }

                // 세로 체크
                if (values[j][i] == '.') {
                    h++;
                }
                if (values[j][i] == 'X' || j == n -1 ) {
                    if (h >= 2) {
                        height++;
                    }
                    h = 0;
                }
            }
        }

        System.out.println(width + " " + height);
    }
}
