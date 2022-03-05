package BOJ.Bronze.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[][] chess = new String[8][8];

        for(int i=0; i<8; i++) {
            String part_chess = buf.readLine();
            String[] part_chess_arr = part_chess.split("");
            int j = 0;
            for(String s : part_chess_arr) {
                chess[i][j] = s;
                j++;
            }
        }

        int result = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(i%2 ==0 && j%2==0 && chess[i][j].equals("F"))
                    result++;

                if(i%2==1 && j%2==1 && chess[i][j].equals("F"))
                    result++;
            }
        }

        System.out.println(result);

    }
}
