package leetcode.medium;

// 91. Decode Ways
class _91 {
    // 엄청 어렵다... ㅠㅠ 이해하기 어려운 문제인 것 같다.
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        // dp[i] -> 첫 번째 숫자부터 i번째 숫자까지 부분 문자열을 디코딩하는 방법의 수
        // 0으로 시작하는 경우도 있기 때문에 이에 대해서는 0으로 설정
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        // 1개의 숫자를 그룹으로 나누지 않으면 어차피 자기 자신만 디코딩하는 방법이니까 1가지.
        // 만약 2개의 숫자를 그룹으로 나누면 그 자체에 대한 것 + 묶은 것 이렇게 2개...?
        for (int i=2; i<=s.length(); i++) {
            // i-1번째 숫자와 i번째 숫자를 그룹으로 나누지 않을 경우 = i-1번째 숫자 자체
            int one = Integer.parseInt(String.valueOf(s.charAt(i-1)));

            // i-1번째 숫자와 i번째의 숫자를 그룹으로 나누는 경우 
            int two = Integer.parseInt(s.substring(i-2, i));

            // one의 경우 무조건 한 자리 숫자니까 1~9 사이인지 검증
            if (1 <= one && one <= 9) {
                dp[i] += dp[i-1];
            }

            // two의 경우 두 자리 숫자니까 10~26 사이인지 검증
            if (10 <= two && two <= 26) {
                dp[i] += dp[i-2]; // 이때 두 자리 이전의 값에 대한 방법의 수 저장
            }
        }

        return dp[s.length()];
    }
}
