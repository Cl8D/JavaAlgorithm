package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 가위바위보
public class _0203 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int[] gameA = new int[n];
        int[] gameB = new int[n];

        StringTokenizer stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            gameA[i] = Integer.parseInt(stk.nextToken());

        StringTokenizer stk2 = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            gameB[i] = Integer.parseInt(stk2.nextToken());

        // 1: 가위, 2:바위, 3:보
        // 1<2 : 이김, 2<3: 이김, 1>3 이김


        for(int i=0; i<n; i++) {
            if(gameA[i] == gameB[i])
                System.out.println("D");
            else {
                if (gameA[i] == 1) {
                    if (gameB[i] == 2)
                        System.out.println("B");
                    else
                        System.out.println("A");
                }
                else if (gameA[i] == 2) {
                    if (gameB[i] == 3)
                        System.out.println("B");
                    else
                        System.out.println("A");
                }
                else {
                    if (gameB[i] == 1)
                        System.out.println("B");
                    else
                        System.out.println("A");
                }
            }
        }

    }
}
