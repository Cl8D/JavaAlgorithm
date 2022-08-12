package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 재귀함수가 뭔가요?
public class _17478 {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        sb = new StringBuilder("");
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        sb.append("\"재귀함수가 뭔가요?\"\n");
        recur(0, "");

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void recur(int cnt, String prefix) {
        if(cnt==n) {
            sb.append(prefix).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(prefix).append("라고 답변하였지.\n");
            return;
        }
        sb.append(prefix).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(prefix).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(prefix).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        sb.append(prefix).append("____").append("\"재귀함수가 뭔가요?\"\n");
        recur(cnt+1, prefix+"____");
        sb.append(prefix).append("라고 답변하였지.\n");
    }
}
