package Programmers.Level2;

// 다음 큰 숫자
class NextBigValue {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while(true) {
            n++;
            int nowCnt = Integer.bitCount(n);
            if (cnt == nowCnt) {
                return n;
            }
        }

    }

}