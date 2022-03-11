package BOJ.Silver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Map<String, Integer> person = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            person.put(buf.readLine(), i);
        }

        for(int i=0; i<m; i++) {
            String people = buf.readLine();
            if(person.containsKey(people))
                result.add(people);
        }

        System.out.println(result.size());

        Collections.sort(result);

        for(String p : result) {
            System.out.println(p);
        }
    }
}
