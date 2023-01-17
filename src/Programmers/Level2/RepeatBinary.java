package Programmers.Level2;

// 이진 변환 반복하기
class RepeatBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int transformCnt = 0;
        int removeCnt = 0;

        while(!s.equals("1")){
            int before = s.length();
            s = s.replaceAll("0", "");

            int after = s.length();
            s = Integer.toString(after, 2);

            transformCnt++;
            removeCnt += (before - after);
        }

        answer[0] = transformCnt;
        answer[1] = removeCnt;
        return answer;
    }
}