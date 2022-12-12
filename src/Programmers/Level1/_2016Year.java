package Programmers.Level1;

// 2016년
class _2016Year {
    private static final int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    // 금요일부터 시작
    private static final String[] dayWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    private static final int DAY = 7;

    public String solution(int a, int b) {
        String answer = "";
        int day = 0;
        for (int i = 0; i < a-1; i++) {
            day += months[i];
        }
        day += b;
        answer = dayWeek[day % DAY];
        return answer;
    }
}