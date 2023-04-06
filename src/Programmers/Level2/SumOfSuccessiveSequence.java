package Programmers.Level2;

// 연속된 부분 수열의 합
class SumOfSuccessiveSequence {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE;

        int n = sequence.length;
        int[] sum = new int[n + 1];
        for (int i=1; i<=n; i++) {
            sum[i] = sequence[i-1];
        }

        for (int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + sequence[i-1];
        }

        int left = 0, right = 0;
        while (left <= right && right <= n) {
            int partSum = sum[right] - sum[left];
            if (partSum == k) {
                int count = right - left;
                if ((count == length && left < answer[0]) || (count < length)) {
                    answer[0] = left;
                    answer[1] = right - 1;
                    length = count;
                }
                left++;
            }
            if (partSum > k) {
                left++;
            } else {
                right++;
            }
        }
        return answer;
    }
}
