package BOJ.Silver.Silver5;

import java.io.*;
import java.util.StringTokenizer;

// 크로아티아 알파벳
public class _2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String s = buf.readLine();
        s = s.replaceAll("c=", "a");
        s = s.replaceAll("c-", "a");
        s = s.replaceAll("dz=", "a");
        s = s.replaceAll("d-", "a");
        s = s.replaceAll("lj", "a");
        s = s.replaceAll("nj", "a");
        s = s.replaceAll("s=", "a");
        s = s.replaceAll("z=", "a");

        buf2.write(s.length() + "");
        buf2.flush();

        buf.close();
        buf2.close();
    }
}
