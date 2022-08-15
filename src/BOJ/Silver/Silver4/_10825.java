package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 국영수
public class _10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        List<Student> list = new ArrayList<>();

        int n = Integer.parseInt(buf.readLine());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String name = stk.nextToken();
            int korean = Integer.parseInt(stk.nextToken());
            int english = Integer.parseInt(stk.nextToken());
            int math = Integer.parseInt(stk.nextToken());
            list.add(new Student(name, korean, english, math));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.kor == o2.kor) {
                if(o1.eng == o2.eng) {
                    if(o1.math == o2.math)
                        return o1.name.compareTo(o2.name);
                    return o2.math - o1.math;
                }
                return o1.eng - o2.eng;
            }
            return o2.kor - o1.kor;
        });

        StringBuilder sb = new StringBuilder("");
        for(Student stu : list) {
            sb.append(stu.getName()).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }
    }
}
