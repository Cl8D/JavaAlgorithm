package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7. 교육과정 설계
public class _0507 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        String need = buf.readLine();
        String[] needArr = need.split("");
        String[] lecture = buf.readLine().split("");

        Queue<String> queue = new LinkedList<>();

        for(String s : lecture)
            queue.add(s);

        String result = "";
        while(!queue.isEmpty()){
            for(String s : needArr){
                if(queue.peek().equals(s)) {
                    result += queue.peek();
                    break;
                }
            }
            queue.poll();
        }

        if(result.equals(need))
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}
