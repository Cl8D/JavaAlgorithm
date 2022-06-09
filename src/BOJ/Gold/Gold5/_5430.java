package BOJ.Gold.Gold5;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// AC
public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 양방향 queue
        // 참고) https://cocoon1787.tistory.com/795

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            // 나는 정말 바보야......... 구현은 다 맞게 했는데 처음에 deque를 character형으로 선언해놔서 배열의 값이 2자리수 이상이 들어오면 처리가 잘 안 됐다...ㅎㅎ
            Deque<String> deque = new LinkedList<>();

            String oper = buf.readLine();
            int n = Integer.parseInt(buf.readLine());
            String val = buf.readLine();

            val = val.replace("[", "");
            val = val.replace("]", "");

            String[] split = val.split(",");

            for(String s: split) {
                if(!s.equals(""))
                    deque.addFirst(s);
            }

            // 짝수면 오른쪽 방향 삭제(removeLast),
            // 홀수면 왼쪽 방향 삭제(removeFirst)
            int mode = 0;
            boolean check = false;
            for(char c: oper.toCharArray()) {
                if(c=='R')
                    mode++;
                else if(c=='D') {
                    if(deque.isEmpty()) {
                        buf2.write("error\n");
                        check = true;
                        break;
                    }
                    else if(mode%2==0)
                        deque.removeLast();
                    else
                        deque.removeFirst();
                }
            }

            if(!check) {
                buf2.write("[");
                if(mode%2==0) {
                    while (!deque.isEmpty()) {
                        if(deque.size()==1)
                            buf2.write(deque.removeLast());
                        else
                            buf2.write(deque.removeLast() + ",");
                    }
                }
                else {
                    while (!deque.isEmpty()) {
                        if(deque.size()==1)
                            buf2.write(deque.removeFirst());
                        else
                            buf2.write(deque.removeFirst() + ",");
                    }
                }

                buf2.write("]\n");
            }
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}