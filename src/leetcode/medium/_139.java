package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 139. Word Break
class _139 {

    public static void main(String[] args) {
        String s = "leetcode";
        final List<String> dicts = List.of("leet", "code");
        final boolean result = wordBreak(s, dicts);
        System.out.println(result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // 해당 위치까지의 문자열이 wordDict로 분할 가능한지 저장
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> words = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            // 끝에서부터 탐색을 진행하여 시간 복잡도 막기
            for (int j = i - 1; j >= 0; j--) {
                // 이전 인덱스까지가 분할 가능한지 체크하고,
                // 분할 가능하다면 주어진 문자열을 j~i만큼 자른게 사전에 포함하는지 확인 = 분할 가능
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
