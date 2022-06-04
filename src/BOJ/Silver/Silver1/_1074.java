package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// Z
public class _1074 {
    static int r, c, count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        int size = (int)Math.pow(2, n);
        recur(0,0, size);

    }

    static void recur(int x, int y, int size) {
        if(x==r && y==c) {
            System.out.println(count);
            System.exit(0);
        }

        // 사분면 그냥 내맘대로 왼쪽 위부터 1 2 3 4라고 생각함... ㅎㅎ
        // 1사분면 - (x, y, size/2)
        // 2사분면 - (x, y+size/2, size/2)
        // 3사분면- (x+size/2, y, size/2)
        // 4사분면 - (x+size/2, y+size/2, size/2)

        // 어떤 사분면에 해당하는지 판단
        // (x+size, y+size) -> 해당 면의 가장 끝좌표-1의 값.
        // ex) 1사분면의 끝값은 (1,1)인데 저값은 (2,2)임
        // 아무튼 우리가 원하는 위치 (r,c)보다 커야 하는 값임.
        if(x <= r && y <= c && x+size > r && y+size > c) {
            // 실질적으로 newSize=1이 되었을 때가 가장 작은 2x2에서 Z 탐색을 한다고 볼 수 있음.
            // 즉, 2x2내의 4칸도 어떻게 보면 1, 2, 3, 4사분면이라고 볼 수 있으니까...!
            int newSize = size / 2;
            recur(x, y, newSize);
            recur(x, y + newSize, newSize);
            recur(x + newSize, y, newSize);
            recur(x + newSize, y + newSize, newSize);
        }
        else
            // 시작점을 증가해주는 형태... newSize=1일 때는 각 칸에 대한 값이라고도 볼 수 있음!
            count += size * size;
    }
}