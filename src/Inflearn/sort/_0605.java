package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 5. 중복 확인
public class _0605 {
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
