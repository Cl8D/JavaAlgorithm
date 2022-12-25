package Programmers.Level1;

import java.util.*;

// 최소 직사각형
class MinimalRectangular {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxV = 0;
        for (int[] size : sizes) {
            int lenW = Math.max(size[0], size[1]);
            int lenV = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, lenW);
            maxV = Math.max(maxV, lenV);
        }
        return maxW * maxV;
    }
}