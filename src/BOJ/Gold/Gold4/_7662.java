package BOJ.Gold.Gold4;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 이중 우선순위 큐
public class _7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {

            // 우선순위 큐를 사용하는 것보다는 최대, 최소 뽑을 때는 treemap 써주는 게 좋을 듯!
            // firstKey(): 최소, lastKey(): 최대
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(buf.readLine());
            for(int j=0; j<k; j++) {
                // I: 삽입, D 1: 최댓값 삭제, D -1: 최솟값 삭제
                // 2개 이상은 하나만 삭제
                stk = new StringTokenizer(buf.readLine());
                String oper = stk.nextToken();
                int val = Integer.parseInt(stk.nextToken());

                if(oper.equals("I")) {
                    // val값은 중복이 가능하니까... 삭제할 때 개수 개념 이용하기
                    // value 값으로 개수를 key의 개수를 집어넣기
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
                else if(oper.equals("D")) {
                    if(map.isEmpty()) { //비어있으면 무시
                        continue;
                    }

                    if(val == -1) {
                        int min = map.firstKey();
                        int cnt = map.get(min);
                        if(cnt==1) // 1개라면 지우기
                            map.remove(min);
                        else // 1개 이상이면 cnt만 갱신해주기 - 어차피 중복키는 안 되니까 갱신된다는 개념 생각하기!
                            map.put(min, cnt-1);
                    }
                    else {
                        int max = map.lastKey();
                        int cnt = map.get(max);
                        if(cnt==1)
                            map.remove(max);
                        else
                            map.put(max, cnt-1);
                    }
                }
            }

            if(map.isEmpty())
                buf2.write("EMPTY\n");
            else
                buf2.write(map.lastKey() + " " + map.firstKey() + "\n");


        }

        buf2.flush();
        buf.close();
        buf2.close();
    }



}