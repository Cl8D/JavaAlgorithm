package BOJ.Silver.Silver5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 집합
public class _11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 삽질 내역) 함수 분리 -> 굳이...? 싶어서 그냥 메인으로 합침 -> List -> Set -> if문에서 switch문으로 변경
        // 시간 초과 났던 건... bufferedWriter의 잘못된 사용법 때문이었다........ㅎ flush는 꼭 마지막에 한 번만 해주도록 하자........!
        Set<Integer> set = new HashSet<>();
        int m = Integer.parseInt(buf.readLine());

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            String operation = stk.nextToken();
            int num = 0;
            if(stk.hasMoreTokens())
                num = Integer.parseInt(stk.nextToken());

            switch (operation) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    if (set.contains(num))
                        buf2.write("1\n");
                    else
                        buf2.write("0\n");
                    break;
                case "toggle":
                    if (set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++)
                        set.add(j);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        buf2.flush();
    }


}