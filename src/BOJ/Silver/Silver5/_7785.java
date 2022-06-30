package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 회사에 있는 사람
public class _7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        Set<String> company = new HashSet<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String name = stk.nextToken();
            company.add(name);
            if(stk.nextToken().equals("leave"))
                company.remove(name);
        }

        List<String> list = new ArrayList<>(company);
        Collections.sort(list, Collections.reverseOrder());

        for(String s : list)
            buf2.write(s+"\n");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
