package leetcode.medium;

// 134. Gas Station
class _134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int current = 0;
        int answer = 0;
        for (int i=0; i<gas.length; i++) {
            total += gas[i] - cost[i]; // 총 가스양
            current += gas[i] - cost[i];

            if (current < 0) {
                answer = i + 1; // 다음 역 탐색
                current = 0;
            }
        }

        // 순환이 가능하다면 항상 필요한 사용한 총 가스양은 양수일 것임
        if (total < 0) {
            return -1;
        }
        return answer;
    }
}
