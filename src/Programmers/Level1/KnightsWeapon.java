package Programmers.Level1;

// 기사단원의 무기
class KnightsWeapon {
    private static int[] dp;
    public int solution(int number, int limit, int power) {
        int answer = 0;
        dp = new int[number+1];

        // number -> 기사에게 지정되어 있는 번호
        // 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
        // 제한수치 넘기면 협약 기간에서 정한 공격력 무기로 구매해야 함.
        // 무기 생산 시 공격력 1당 1kg의 철 필요함.

        // 각 배수에 대해서 체크를 진행하기.
        for (int i=1; i<=number; i++) {
            int sumCount = 1;
            while (i*sumCount <= number) {
                dp[i*sumCount]++;
                sumCount++;
            }

            int count = dp[i];
            if (count > limit) {
                count = power;
            }
            answer+=count;
        }

        return answer;
    }
}