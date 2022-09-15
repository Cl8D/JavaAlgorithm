package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 사이버 개강총회
public class _19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        String s = stk.nextToken();
        String e = stk.nextToken();
        String q = stk.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        String input = null;

        while((input = buf.readLine()) != null) {
            String[] arr = input.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(s.compareTo(time) >= 0) {
                before.add(name);
            } else if(e.compareTo(time) <= 0 && q.compareTo(time) >= 0) {
                after.add(name);
            }
        }

        int answer = 0;
        for(String name : nameSet) {
            if(before.contains(name) && after.contains(name)) {
                answer += 1;
            }
        }
        System.out.println(answer);

        buf2.flush();
        buf.close();
        buf2.close();
    }
}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stk;
//        StringBuilder sb = new StringBuilder("");
//
//        stk = new StringTokenizer(buf.readLine());
//        // 개총 시작한 시간
//        String[] s = stk.nextToken().split(":");
//        int sHour = Integer.parseInt(s[0]);
//        int sMin = Integer.parseInt(s[1]);
//
//        // 개총 끝낸 시간
//        String[] e = stk.nextToken().split(":");
//        int eHour = Integer.parseInt(e[0]);
//        int eMin = Integer.parseInt(e[1]);
//
//        // 개총 스트리밍 끝낸 시간
//        String[] q = stk.nextToken().split(":");
//        int qHour = Integer.parseInt(q[0]);
//        int qMin = Integer.parseInt(q[1]);
//
//        Map<String, Integer> enter = new HashMap<>();
//
//        int answer = 0;
//        String input = null;
//
//        // stringtokenizer를 써서 사용하는 방법은 안 된다...
//        // 로직은 맞는데 EOF 처리를 너무 애먹어서 ㅠ
//        while((input = buf.readLine()) != null) {
//            String[] inputArr = input.split(" ");
//
//            String time = inputArr[0];
//            String name = inputArr[1];
//
//            String[] timeArr = time.split(":");
//            int timeHour = Integer.parseInt(timeArr[0]);
//            int timeMin = Integer.parseInt(timeArr[1]);
//
//            // 개총 시작 전 대화를 한 적 있다면 입장으로 간주
//            if (timeHour < sHour || ((timeHour == sHour) && (timeMin <= sMin))) {
//                enter.put(name, enter.getOrDefault(name, 0) + 1);
//                continue;
//            }
//            // 개총 종료 ~ 스트리밍 종료 사이 대화했다면 퇴장으로 간주
//            else if (((eHour <= timeHour) && (timeHour < qHour)) || (timeHour == qHour && timeMin <= qMin)) {
//                enter.put(name, enter.getOrDefault(name, 0) + 1);
//            }
//            // 시간이 지났을 경우 더 이상 진행 X
//            else {
//                continue;
//            }
//            Integer val = enter.get(name);
//            if (val == 2) {
//                answer++;
//            }
//        }
//        buf2.write(answer);
//        buf2.flush();
//
//
//
//        buf.close();
//        buf2.close();
//    }
//}
