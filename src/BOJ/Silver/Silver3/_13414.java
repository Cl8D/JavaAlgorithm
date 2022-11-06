package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 수강신청
public class _13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 수강신청을 더 빨리 누른 학생이 대기목록에 먼저 들어감
        // 들어가있는데 누르면 맨 뒤로 감
        // 비활성화 되면 맨 앞부터 자동으로 신청 완료함
        stk = new StringTokenizer(buf.readLine());

        // 과목의 수강 가능 인원
        int k = Integer.parseInt(stk.nextToken());

        // 학생들이 버튼을 클릭한 순서를 기록한 대기목록 길이
        int l = Integer.parseInt(stk.nextToken());

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            // 학번
            String str = buf.readLine();
            if (set.contains(str)) {
                set.remove(str);
                set.add(str);
                continue;
            }
            set.add(str);
        }

        int count = 0;
        for(String student : set) {
            // 수강 가능 인원보다 수강신청한 인원이 더 작을 수 있으니까 break만 걸어둬야 한다. (여기서 출력 x)
            if (count == k) {
                break;
            }
            sb.append(student).append("\n");
            count++;
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}