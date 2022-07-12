package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 요세푸스 문제
public class _1158 {

    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }
        int temp = 0;
        StringBuilder sb = new StringBuilder("<");
        while(!queue.isEmpty()){
            if(temp==k-1) {
                sb.append(queue.poll() + ", ");
                temp = 0;
            }
            else {
                queue.add(queue.poll());
                temp++;
            }
        }


        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        buf2.write(sb.toString());
        buf2.flush();

        buf.close();
        buf2.close();

    }

}
