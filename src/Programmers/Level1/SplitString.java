package Programmers.Level1;

// 문자열 나누기
class SplitString {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0, xNotCount = 0;
        char ch = s.charAt(0);

        for (int i=0; i<s.length(); i++) {
            if (xCount == xNotCount) {
                answer++;
                ch = s.charAt(i);
            }
            if (ch == s.charAt(i)) {
                xCount++;
            } else {
                xNotCount++;
            }
        }


        return answer;
    }
}