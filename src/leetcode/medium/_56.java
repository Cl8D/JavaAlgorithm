package leetcode.medium;

import java.util.*;

// 56. Merge Intervals
class _56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        List<int[]> list = new ArrayList<>();


        int[] temp = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                int endValue = Math.max(temp[1], intervals[i][1]);
                temp = new int[]{temp[0], endValue};
            } else {
                list.add(temp);
                temp = intervals[i];
            }
        }

        list.add(temp);

        int[][] answer = new int[list.size()][2];
        int index = 0;
        for (int[] ans : list) {
            answer[index++] = ans;
        }

        return answer;
    }
}
