package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 신입 사원
public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            List<Member> list = new ArrayList<>();

            int n = Integer.parseInt(buf.readLine());
            for(int j=0; j<n; j++) {
                stk = new StringTokenizer(buf.readLine());
                Member member = new Member(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
                list.add(member);
            }

            list.sort(Comparator.comparingInt(o -> o.docs));
            int score = list.get(0).interview;
            int answer = 1;

            for(int j=1; j<n; j++) {
                if(list.get(j).interview < score) {
                    score = list.get(j).interview;
                    answer++;
                }
            }
            buf2.write(answer + "\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
    static class Member {
        // 서류 성적 순위, 면접 성적의 순위
        int docs;
        int interview;

        public Member(int docs, int interview) {
            this.docs = docs;
            this.interview = interview;
        }
    }
}
