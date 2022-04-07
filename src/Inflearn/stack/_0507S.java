package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7. 교육과정 설계 - 솔루션 코드
public class _0507S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 기존에 내가 짰던 코드는 잘못된 코드 같은데, 이상하게 정답입니다라고 떠서...
        // 솔루션 코드 작성.

        char[] need = buf.readLine().toCharArray();
        char[] lecture = buf.readLine().toCharArray();

        Queue<Character> queue = new LinkedList<>();
        for(char c : need)
            queue.add(c);


        boolean right = true;

        for(char c : lecture) {
            // 필수 과목이라면
            if(queue.contains(c)) {
                // 순서대로 되어 있지 않는다면
                if(c != queue.poll())
                    right = false;
            }
        }

        // 순서대로 되어 있어야 큐가 완전하게 비게 된다.
        if(!queue.isEmpty())
            right = false;

        if(right)
            System.out.println("YES");
        else
            System.out.println("NO");



    }
}
