package Programmers.Level1;

// 크기가 작은 부분 문자열
public class SmallPartString {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long num = Long.parseLong(p);
        for (int i = 0; i <= t.length() - len; i++) {
            if (Long.parseLong(t.substring(i, i + len)) <= num) {
                answer++;
            }
        }
        return answer;
    }
}