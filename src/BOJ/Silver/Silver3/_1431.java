package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 시리얼 번호
public class _1431 {
    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        String[] val = new String[n];

        for(int i=0; i<n; i++){
            val[i] = buf.readLine();
        }

        Arrays.sort(val, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                int val1 = 0, val2 = 0;

                String intVal1 = o1.replaceAll("[^0-9]", "");
                String[] sArr1 = intVal1.split("");

                if(intVal1.length() > 0) {
                    for (String str : sArr1) {
                        val1 += Integer.parseInt(str);
                    }
                }

                String intVal2 = o2.replaceAll("[^0-9]", "");
                String[] sArr2 = intVal2.split("");

                if(intVal2.length() > 0) {
                    for (String str : sArr2) {
                        val2 += Integer.parseInt(str);
                    }
                }
                if(val1 == val2) {
                    return o1.compareTo(o2);
                }
                return val1 < val2 ? -1 : 1;
            }
            return o1.length() < o2.length () ? -1 : 1;
        });

        for(String v : val) {
            sb.append(v).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

}
