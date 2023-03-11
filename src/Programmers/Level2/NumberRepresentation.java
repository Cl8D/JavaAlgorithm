package Programmers.Level2;

// 숫자의 표현
class NumberRepresentation {
    public int solution(int n) {
        int answer = 0;

        int start = 1, end = 1;
        int sum = end;
        while (start <= end) {
            if (sum < n) {
                sum += ++end;
                continue;
            }

            if (sum == n) {
                answer++;
            }

            sum -= start;
            start++;
        }

        return answer;
    }
}
