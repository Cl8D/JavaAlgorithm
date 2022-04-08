
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Set<Integer> set = new HashSet<>();
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            set.add(Integer.parseInt(stk.nextToken()));

        if(set.size() == n)
            System.out.println("U");
        else
            System.out.println("D");


    }
}

