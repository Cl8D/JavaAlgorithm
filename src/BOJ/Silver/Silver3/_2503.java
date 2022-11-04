package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 숫자 야구
public class _2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        int result = 0;

        List<BaseballGame> input = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String question = stk.nextToken();
            int strike = Integer.parseInt(stk.nextToken());
            int ball = Integer.parseInt(stk.nextToken());
            input.add(new BaseballGame(question, strike, ball));
        }

        // 숫자 야구에서 나올 수 있는 숫자 값
        // 모든 경우에 대해서 검사를 진행한다.
        for (int i = 123; i <= 987; i++) {
            // 중복 숫자 검사
            List<Character> numList = checkDuplicate(i);
            if(numList.size() != 3) {
                continue;
            }

            int temp = 0;

            for (int j = 0; j < n; j++) {
                String question = input.get(j).question;
                int ansStrike = input.get(j).strike;
                int ansBall = input.get(j).ball;

                int strike = 0, ball = 0;

                // 모든 경우에 대해서 직접 하나씩 생각해보기
                for (int k = 0; k < 3; k++) {
                    // 위치랑 숫자가 모두 동일할 경우
                    if (numList.get(k) == question.charAt(k)) {
                        strike++;
                        continue;
                    }
                    // 위치는 다르지만 숫자만 동일할 경우
                    if (numList.contains(question.charAt(k))) {
                        ball++;
                    }
                }

                // 일치하면 temp 더해주기
                if (strike == ansStrike && ball == ansBall) {
                    temp++;
                }
            }

            // 주어진 모든 경우에 대해서 일치한다면 증가
            if (temp == n) {
                result++;
            }
        }

        System.out.println(result);
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static List<Character> checkDuplicate(int val) {
        String strNum = String.valueOf(val);
        List<Character> numList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < 3; i++) {

            // 1~9 사이의 값이어야 하니까
            if (strNum.charAt(i) == '0') {
                flag = true;
            }

            // 중복되지 않은 수만 리스트에 넣기
            if (!numList.contains(strNum.charAt(i))) {
                numList.add(strNum.charAt(i));
            }
        }

        // 0이 들어가면 그냥 의미없는 빈 배열 보내버리기
        if (flag) {
            return new ArrayList<>();
        }

        return numList;
    }

    public static class BaseballGame {
        String question;
        int strike;
        int ball;

        public BaseballGame(String question, int strike, int ball) {
            this.question = question;
            this.strike = strike;
            this.ball = ball;
        }
    }
}