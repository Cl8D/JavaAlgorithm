package BOJ.Gold.Gold5;

import java.util.*;
import java.io.*;

// 스타트링크
public class _5014 {

    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());
        f = Integer.parseInt(stk.nextToken()); // 총 건물의 층 수
        s = Integer.parseInt(stk.nextToken()); // 현재 있는 층 수
        g = Integer.parseInt(stk.nextToken()); // 가야 하는 층 수
        u = Integer.parseInt(stk.nextToken()); // 위로 가는 층 수
        d = Integer.parseInt(stk.nextToken()); // 아래로 가는 층 수

        Queue<Type> queue = new LinkedList<>();
        queue.add(new Type(s, 0));
        boolean[] visited = new boolean[f+1];

        visited[s] = true;
        boolean flag = true;

        while(!queue.isEmpty()){
            Type current = queue.poll();

            int uStair = elevator('u', current.answer);
            int dStair = elevator('d', current.answer);

            if(current.answer == g) {
                System.out.println(current.count);
                flag = false;
                break;
            }

            if(uStair >= 1 && uStair <= f){
                if(!visited[uStair]) {
                    visited[uStair] = true;
                    queue.add(new Type(uStair, current.count + 1));
                }
            }

            if(dStair >=1 && dStair <= f){
                if(!visited[dStair]) {
                    visited[dStair] = true;
                    queue.add(new Type(dStair, current.count+1));
                }
            }
        }
        if(flag)
            System.out.println("use the stairs");

    }
    static int elevator(char mode, int stair) {
        if(mode == 'u') {
            return (stair += u);
        }
        else {
            return (stair -= d);
        }
    }

    static class Type{
        int answer;
        int count;

        public Type(int answer, int count){
            this.answer = answer;
            this.count = count;
        }

    }

}
