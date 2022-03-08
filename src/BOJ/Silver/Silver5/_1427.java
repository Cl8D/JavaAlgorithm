package BOJ.Silver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String n = buf.readLine();

        String[] str_n = n.split("");

        Integer[] arr = new Integer[n.length()];

        int idx= 0;
        for(String part_n : str_n) {
            int int_n = Integer.parseInt(part_n);
            arr[idx] = int_n;
            idx++;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int sort_n : arr) {
            System.out.print(sort_n);
        }

    }
}
