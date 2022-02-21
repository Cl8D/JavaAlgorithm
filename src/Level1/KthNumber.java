package Level1;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        int cnt = 0;
        for (int i=0; i<commands.length; i++) {
            int[] temp = {};

            int a = commands[i][0]; // 2
            int b = commands[i][1]; // 5
            int c = commands[i][2]; // 3

            temp = new int[b-a+1];

            int idx = 0;
            for(int j=a-1; j<b; j++) {
                temp[idx] = array[j];
                idx++;
            }

            // 오름차순 정렬시 사용
            Arrays.sort(temp);
            answer[cnt] = temp[c-1];
            cnt++;
        }

        return answer;
    }
}
