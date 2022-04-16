package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10. 마구간 정하기 (결정 알고리즘)
// ㅠㅠ 결정 알고리즘 아직 개념이 잘 안 잡혀서 솔루션 보면서 했다
public class _0610 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        // 1 2 4 8 9
        Arrays.sort(val);
        int answer = 0;
        int lt = 1;
        int rt = val[n-1];
        while(lt <= rt) {
            int mid = (lt+rt) / 2;
            // 리턴된 말의 수가 c보다 크면 유효하다는 것.
            // (리턴된 말의 수가 더 많으면 c마리는 당연히 마구간에 넣을 수 있다는 의미니까)
            if(count(val, mid) >= c) {
                answer = mid;
                // 더 좋은 값 (더 큰 값을 찾아야 하니까) 탐색 범위 바꾸기
                lt = mid+1;
            } else {
                // 더 작은 값을 봐야 하니까
                rt = mid-1;
            }
        }

        System.out.println(answer);

    }

    static int count(int[] val, int dist) {
        // 마구간에 배치된 말의 수
        int cnt = 1;
        // 가장 왼쪽 자리에 말 1마리 배치해둠
        // 가장 최근에 말을 비치한 마구간의 값을 담는 변수
        int ep = val[0];

        for(int i=1; i<val.length; i++) {
            // 현재 마굿간부터 바로 이전에 말을 비치한 마굿간의 위치 빼주기
            // 곧, 이게 거리가 된다.
            // 파라미터로 넘어온 dist 값 (=위에서 mid값)은
            // 가장 가까운 두 말의 거리가 된다.
            if(val[i]-ep >= dist) {
                // 아무튼 우리는 여기서 최대 거리를 구하는 거니까,
                // 만약 거리가 더 크다면 말 한 마리 더 추가, 마구간 값 갱신
                cnt++;
                ep=val[i];
            }
        }

        return cnt;

    }

}
