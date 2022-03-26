package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 10. 문자 거리 - 솔루션 코드
public class _0110S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        String str = stk.nextToken();
        String t = stk.nextToken();
        // string to char
        char chT = t.charAt(0);


        // 핵심) 하나의 문자를 기준으로 '왼쪽'에 있는 t의 값만 보는 과정과
        // '오른쪽'에 있는 t의 값만 보는 과정을 진행하여
        // 둘 중 더 작은 값 = 즉, 더 작은 거리만큼 떨어져있는 값을 리턴하는 과정.

        int[] answer = new int[str.length()];

        int min = 1000;
        // 왼쪽에 있는 애들만 생각해주기
        for(int i =0; i<str.length(); i++) {
            // 만약 주어진 문자와 동일한 위치라면
            if(str.charAt(i) == chT) {
                min = 0;
                answer[i] = min;
            }
            else {
                // 왼쪽에 있는 애들보다 얼마나 떨어져 있는지.
                // 한 칸씩 증가하니까 1씩 증가시켜주기.
                min++;
                answer[i] = min;
            }
        }

        // 오른쪽에 있는 애들 생각해주기
        // 이때, 왼쪽에 있는 애들로 나온 거리보다 작을 경우만 갱신
        min = 1000;
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == chT) {
                // 이미 왼쪽에 있는 애들 탐색했을 때 answer배열에는 0이 들어갔으니까 생략
                min = 0;
            }
            else {
                min++;
                answer[i] = Math.min(answer[i], min);
            }
        }

        for(int a : answer) {
            System.out.print(a + " ");
        }
    }
}
