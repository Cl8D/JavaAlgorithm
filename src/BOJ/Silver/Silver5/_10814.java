package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 나이순 정렬
public class _10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        List<Member> list = new ArrayList<>();

        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int age = Integer.parseInt(stk.nextToken());
            String name = stk.nextToken();
            Member member = new Member(age, name, i);
            list.add(member);
        }

        list.sort((o1, o2) -> {
            if(o1.age == o2.age) {
                return o1.order - o2.order;
            }
            return o1.age - o2.age;
        });

        StringBuilder sb = new StringBuilder();
        list.forEach(member -> {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        });

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
    static class Member {
        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
