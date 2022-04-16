package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 재귀함수 (스택프레임)
public class _0701 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        // 재귀함수 - dfs 사용하기
        // 이때, 재귀함수는 stack을 사용한다!
        dfs(n);

    }

    // dfs 구조 잡기 (if-else)
    static void dfs(int n) {
        if(n==0)
            return; // 함수 종료
        else {
            dfs(n-1);
            // 이런 식으로 dfs 호출부 밑에 출력부를 넣어두면 1-2-3 순서로 출력된다.
            System.out.print(n + " ");
        }
    }

    /**
     * 재귀함수 -> stack frame이 생긴다.
     * 이때 호출된 함수의 매개변수와 지역변수 정보, 복귀되는 주소가 들어간다고 생각하자.
     * <stack>
     *     작동은 stack의 최상단에 있는 애가 된다.
     *     dfs(0) - return; -> pop!
     *     dfs(1) - line 22 (대기) - line 23 (출력) - "1 " => 리턴(종료) -> pop!
     *     dfs(2) - line 22 (대기) - line 23 (출력) - "2 " => 동일한 과정
     *     dfs(3) - line 22 (대기 상태) - "3 " => 동일한 과정
     * </stack>
     * 약간 이런 느낌인 것 같다.
     *
     */

}
