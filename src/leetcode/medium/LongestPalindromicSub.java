package leetcode.medium;

// Longest Palindromic Substring
public class LongestPalindromicSub {
    // 이건 나중에 한 번 더 풀어봐야겠다. 너무 어렵다 ㅠㅠ
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // i를 중심으로 좌우로 확장을 시켜나가가며 팰린드롬의 길이를 확인한다. (홀수 길이의 팰린드롬 체크)
            // i-1, i+1을 계속 늘려나가며 체크하는 방법이다. (문자열의 길이가 1인 것부터 시작)
            int length1 = search(s, i, i);
            // 짝수 길이의 팰린드롬에 대비하여 i와 i+1을 기준으로 좌우로 뻗어나가서 체크한다. (문자열의 길이가 2인 것부터 시작)
            int length2 = search(s, i, i + 1);

            int answer = Math.max(length1, length2);

            // 지금까지 찾은 길이보다 더 길면 업데이트 진행
            int max = end - start;

            if (answer > max) {
                // i는 현재 중심이 되는 인덱스이다. (양쪽으로 뻗어나가니까)
                // 시작 지점은 중심 값에다가 (길이-1)에 2로 나눈 값과 같다.
                start = i - (answer - 1) / 2;
                // 반대로, 끝 지점은 중심 값에다가 길이의 2로 나눈 값이 된다.
                end = i + answer / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int search(String target, int start, int end) {
        while (start >= 0 && end < target.length() && target.charAt(start) == target.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
