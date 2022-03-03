package BOJ.Bronze.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String n = buf.readLine();
        int f = Integer.parseInt(buf.readLine());

        int len = n.length();

        String part_n = n.substring(0, len-2);
        int int_part = Integer.parseInt(part_n += "00");

        int result = 0;

        for(int i=0; i<100; i++) {
            if(int_part % f == 0) {
                result = i;
                break;
            }

            int_part++;
        }

        if (result < 10)
            System.out.println("0" + result);
        else
            System.out.println(result);
    }
}
