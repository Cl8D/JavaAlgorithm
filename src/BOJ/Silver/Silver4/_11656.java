package BOJ.Silver.Silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 접미사 배열
public class _11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String s = buf.readLine();

        List<String> list = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);

        for(String str : list)
            buf2.write(str+"\n");

        buf2.flush();
        buf.close();
        buf2.close();

    }

}
