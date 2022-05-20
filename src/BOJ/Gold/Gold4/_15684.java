package BOJ.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사다리 조작
public class _15684 {
    static int n, m, h;
    static int[][] ladder;
    static int answer = 0;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 세로선의 개수
        n = Integer.parseInt(stk.nextToken());
        // 가로선의 개수
        m = Integer.parseInt(stk.nextToken());
        // 세로선마다 가로선을 놓을 수 있는 위치의 개수
        h =  Integer.parseInt(stk.nextToken());

        ladder = new int[h+1][n+1];


        if(m > 0) {
            for(int i=0; i<m; i++){
                stk = new StringTokenizer(buf.readLine());
                // a번 점선 위치에서 b번과 b+1번 세로선 연결
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                // (a,b)를 기준으로 오른쪽으로 연결되는 가로선 존재
                ladder[a][b] = 1;
                // 왼쪽으로 연결되는 가로선 존재
                ladder[a][b+1] = 2;
            }
        }

        // 가로선은 최대 3개까지 추가가 가능하다.
        // 추가할 가로선의 개수에 대한 모든 경우의 수를 탐색한다고 생각하기.
        for(int i=0; i<=3; i++) {
            answer = i;
            dfs(0);
            if(flag)
                break;
        }

        if(flag)
            System.out.println(answer);
        else
            System.out.println(-1);

    }

    static void dfs(int count) {
        if(flag)
            return;

        // 만약 추가할 사다리의 개수(answer)와 추가된 사다리의 개수(count)가 동일하고
        if(answer == count) {
            // i번으로 출벌해서 i번으로 도착한다면 종료
            if(check())
                flag = true;
            return;
        }

        for(int i=1; i<=h; i++) {
            for(int j=1; j<n; j++) {
                // 가로선 2개는 연속적일 수 없으니까 기존에 연결된 가로선 있는지 확인하가
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
                    // 없다면 가로선을 추가해주기
                    // 1-> 본인 기준 오른쪽에 선 있음, 2-> 본인 기준 왼쪽에 선 있음
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;

                    dfs(count+1);

                    // 백트랙킹 (추가한 가로선 제거하기)
                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }

    // i번 출발 -> i번 도착인지 체크하기
    static boolean check() {
        for(int i=1; i<=n; i++) {
            // nx는 시작점, ny는 출발하는 i번 점을 의미함
            int nx=1, ny=i;

            for(int j=0; j<h; j++) {
                // 오른쪽이랑 연결되어 있으면 한 칸 오른쪽으로 이동
                if(ladder[nx][ny] == 1)
                    ny++;
                    // 왼쪽이랑 연결되어 있으면 한 칸 왼쪽으로 이동
                else if(ladder[nx][ny] == 2)
                    ny--;
                // 아래칸으로 이동
                nx++;
            }

            // 만약 도착했을 때 점이 i가 아니라면 false
            if(ny != i)
                return false;
        }
        // 그게 아니라면 true
        return true;
    }

}