package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 539. Minimum Time Difference
class _539 {
    private final List<Integer> times = new ArrayList<>();
    private int answer = Integer.MAX_VALUE;

    public int findMinDifference(List<String> timePoints) {
        for (String timePoint : timePoints) {
            String[] time = timePoint.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int convertedMinute = hour * 60 + minute;
            times.add(convertedMinute);
        }

        times.sort(Comparator.naturalOrder());

        for (int i=1; i<times.size(); i++) {
            answer = compareTime(i, i - 1);
        }

        // 첫 번째랑 마지막 시간 확인
        answer = compareTime(times.size() - 1, 0);

        return answer;
    }

    private int compareTime(final int nextIdx, final int firstIdx) {
        int diff = times.get(nextIdx) - times.get(firstIdx);
        if (24 * 60 - diff > 0) {
            diff = Math.min(diff, 24 * 60 - diff);
        }
        answer = Math.min(answer, diff);
        return answer;
    }
}
