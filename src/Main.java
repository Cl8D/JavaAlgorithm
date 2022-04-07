
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int s = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[] work = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            work[i] = Integer.parseInt(stk.nextToken());

        int[] cache = new int[s];

        for(int i=0; i<n; i++) {
            for(int j=1; j<n; i++) {
                if(i!=j && cache[i] == cache[j]) {
                    int temp = cache[j];

                }
                else {
                    for(int p=0; p<n-1; p++) {
                        cache[p+1] = cache[p];
                    }
                    cache[0] = cache[i];
                }


            }
        }


    }
}
