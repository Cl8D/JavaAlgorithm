package Programmers.Level3;

import java.util.Arrays;

// 입국 심사
class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        // right 구할 때 꼭 캐스팅 해줘야 한다... 아니면 오류난다.
        long left = 0, right = (long) n * times[times.length - 1];
        long answer = 0;

        while (left < right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid;
                answer = mid;
            }
        }

        return answer;
    }
}
