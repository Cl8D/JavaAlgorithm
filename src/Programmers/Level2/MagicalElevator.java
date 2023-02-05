package Programmers.Level2;

// 마법의 엘레베이터
class MagicalElevator {
    public int solution(int storey) {
        int answer = 0;
        String[] strs = String.valueOf(storey).split("");

        // 2530
        // 2525
        // 2520
        for (int i=strs.length-1; i>=0; i--) {
            int number = Integer.parseInt(strs[i]);

            if (number < 5) {
                answer += number;
                continue;
            }

            if (number > 5) {
                answer += 10 - number;
                if (i-1 >= 0) {
                    int updateNum = Integer.parseInt(strs[i-1]) + 1;
                    strs[i-1] = String.valueOf(updateNum);
                }

                // 가장 첫 자리로 +1을 해줘야 할 때
                if (i == 0) {
                    answer++;
                }
                continue;
            }

            if (i-1 >= 0) {
                int prevNum = Integer.parseInt(strs[i-1]);
                if (prevNum < 5) {
                    answer += number;
                } else {
                    answer += (10 - number);
                    strs[i-1] = String.valueOf(prevNum + 1);
                }
            }

            // 가장 첫 자리가 5일 때
            if (i == 0) {
                answer += number;
            }
        }

        return answer;
    }
}