package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR
public class _9019 {

    static Queue<Type> queue;
    static int first, last;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        // D -> n*2, 9999보다 크면 10000으로 나누기
        // S => n-1, 0이면 9999 저장
        // L => 왼쪽으로 shift (1234 -> 2341)
        // R => 오른쪽으로 shift (1234 -> 4123)

        int t = Integer.parseInt(buf.readLine());

        for(int i=0; i<t; i++) {
            // 실수) 방문처리를 전역으로 선언하면 테스트 케이스마다 초기화를 해야 한다...
            visited = new boolean[10000];
            // 실수2) 마찬가지로 queue로 여기서 이렇게 초기화 안 해주면 테케마다 쌓여서 메모리 초과난다...^^
            queue = new LinkedList<>();

            stk = new StringTokenizer(buf.readLine());
            first = Integer.parseInt(stk.nextToken());
            last = Integer.parseInt(stk.nextToken());

            // 실수4) 시작지점 방문처리... 꼭 해주기
            visited[first] = true;
            queue.add(new Type(first, ""));

            bfs(visited);
        }
    }

    static void bfs(boolean[] visited) {
        while(!queue.isEmpty()){
            Type current = queue.poll();

            int result = current.result;
            String command = current.command;

            int resultD = calculate(result, "D");
            int resultS = calculate(result, "S");
            int resultL = calculate(result, "L");
            int resultR = calculate(result, "R");

            if(result == last) {
                System.out.println(command);
                break;
            }

            // 실수5... 각각의 결과에 대한 방문처리 진행...! else if 사용하는 거 아님...
            if(!visited[resultD]) {
                visited[resultD] = true;
                queue.add(new Type(resultD, command + "D"));
            }
            if(!visited[resultS]) {
                visited[resultS] = true;
                queue.add(new Type(resultS, command + "S"));
            }
            if(!visited[resultL]) {
                visited[resultL] = true;
                queue.add(new Type(resultL, command + "L"));
            }
            if(!visited[resultR]) {
                visited[resultR] = true;
                queue.add(new Type(resultR, command + "R"));
            }

        }
    }

    static int calculate(int val, String mode) {
        if(mode.equals("D")) {
            int result = val * 2;
            if(result > 9999)
                result = result % 10000;
            return result;
        }
        else if(mode.equals("S")) {
            int result = val - 1;
            // 실수3) 문제 제대로 읽기! ㅠ_ㅠ 계산된 결과가 아닌 기존의 n이 0일 때 9999를 리턴해야 함!
            if(val == 0)
                return 9999;
            return result;
        }
        else if(mode.equals("L")) {
            // 1234 -> 2341

            int size = String.valueOf(val).length()-1; // 3
            int temp = (int) Math.pow(10, size); // 1000
            return (val % 1000) * 10 + (val / 1000); // (val % 1000) * 10 + (val / 1000)
//            return val % 1000 * 10 + val / 1000;
        }
        else {
            // 1234 -> 4123
            int size = String.valueOf(val).length()-1; // 3
            int temp = (int) Math.pow(10, size); // 1000
            return (val % 10) * 1000 + (val / 10); // (val % 10) * 1000 + (val / 10)
//            return val % 10 * 1000 + val / 10;
        }
    }

    static class Type {
        int result;
        String command;

        public Type(int result, String command) {
            this.result = result;
            this.command = command;
        }
    }
}
