package BOJ.Silver.Silver2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 에디터
public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;


        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 2개의 스택을 이용하는 문제!
        // P -> left에 요소 추가
        // B -> left의 상단 요소 삭제
        // L -> left->right stack으로 옮겨주기
        // D -> right->left stack으로 옮겨주기

        // 마지막에 출력할 때 left에 있는 걸 right로 다 옮겨준 다음, 스택 내의 있는 값 순차출력 (LIFO)
        // 스택이 경우 모든 연산이 O(1)이기 때문에 매우 빠르다.

        String str = buf.readLine();
        for(char c : str.toCharArray()) {
            left.push(c);
        }

        int n = Integer.parseInt(buf.readLine());

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String oper = stk.nextToken();

            switch (oper) {
                case "P":
                    left.push(stk.nextToken().charAt(0));
                    break;
                case "B":
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case "L":
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            buf2.write(right.pop());
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}