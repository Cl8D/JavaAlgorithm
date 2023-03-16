package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;


// 회전 초밥
public class _2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        // 접시의 수
        int n = Integer.parseInt(stk.nextToken());

        // 초밥의 가짓수
        int d = Integer.parseInt(stk.nextToken());

        // 연속해서 먹는 접시의 수
        // 한 칸씩 움직이면서 최대로 먹을 수 있는 초밥의 종류 구하기
        int k = Integer.parseInt(stk.nextToken());

        // 쿠폰 번호
        int c = Integer.parseInt(stk.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(buf.readLine());
        }

        // 어떠한 종류의 초밥을 몇 개 먹었는지 저장
        int[] eated = new int[d + 1];

        int count = 0;

        // 만약 K개의 초밥을 먹고 종류 체크.
        for (int i = 0; i < k; i++){
            if (eated[sushi[i]] == 0) {
                count++;
            }
            eated[sushi[i]]++;
        }

        // k개를 선택했을 때 초밥의 최대 가짓수.
        int answer = 0;
        if (eated[c] == 0) { // 쿠폰이 있을 경우 한 가지 더 먹은 것으로 추가
            answer = count + 1;
        } else { // 아니라면 그대로
            answer = count;
        }

        // 이미 첫 번째 초밥부터 k개의 초밥을 선택하는 건 위 반복문에서 체크했으니까 1부터 진행.
        // i ~ n - 1 : k개의 연속된 접시 선택
        for (int i = 1; i < n; i++) {
            // 선택된 초밥에서 연속해서 먹는 접시의 수만큼 이동하기 = 선택된 초밥 중 마지막 초밥
            // 이때, 초밥의 개수가 n개이기 때문에 인덱스의 범위를 멋어나지 않도록 하기 위해서 (회전 초밥) n으로 나눠준다.
            int end = (i + k - 1) % n;

            // 마지막 초밥을 안 먹었으면 -> 먹었다고 표시
            if (eated[sushi[end]] == 0) {
                count++;
            }
            eated[sushi[end]]++;

            // 가장 첫 초밥을 안 먹었다고 표시
            eated[sushi[i - 1]]--;
            // 만약 가짓수가 0이 되었다면 종류도 빼주기.
            if(eated[sushi[i - 1]] == 0) {
                count--;
            }

            // 초밥의 최대 가짓수가 더 크게 나온다면
            if (answer <= count) {
                if (eated[c] == 0) { // 쿠폰이 있을 경우 한 가지 더 먹은 것으로 추가
                    answer = count + 1;
                } else { // 아니라면 그대로
                    answer = count;
                }
            }
        }

        System.out.println(answer);
    }
}
