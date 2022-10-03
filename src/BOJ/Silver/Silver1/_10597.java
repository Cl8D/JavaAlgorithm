package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 순열 장난
public class _10597 {
    static boolean[] visited;
    static String origin;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        origin = buf.readLine();

        // 만약 숫자의 최대 길이가 1이라면 s의 길이는 최대 9
        if(origin.length() <= 9) {
            // 단순히 한 칸씩 분리해주기
            for(char c : origin.toCharArray()) {
                System.out.print(c + " ");
            }
        }
        // 그 이상이라면 최대 2자리의 어떤 값을 가진다는 말
        // 최대 50개의 수로 이루어져 있으니까 최대로 나올 수 있는 값이 50까지.
        else {
            // 우선 순열이니까 1~9까지의 값은 무조건 존재하게 된다.
            // 문자열에서 9를 뺀 값에서 2를 나눠주면 10 이상의 개수가 몇 개나 나오는지 알 수 있으니까
            // 곧 순열에서 어떤 값이 최대인지 알 수 있음
            int len = (origin.length() - 9) / 2;
            int max = 9 + len;

            visited = new boolean[max+1];

            dfs(0, max, "");

        }

        buf.close();
        buf2.close();
    }

    static void dfs(int idx, int max, String answer) {
        // 가장 마지막 인덱스까지 탐색 완료 = 모든 요소가 방문되었는지 확인하기
        if(idx == origin.length()) {
            for(int i=1; i<=max; i++) {
                // 하나라도 방문처리 안 된 게 있다면 백트랙킹
                if(!visited[i])
                    return;
            }
            // 양쪽 공백 제거할 때 trim() 사용해주기
            System.out.println(answer.trim());
            System.exit(0);
            return;
        }

        // 1글자만 탐색
        String temp = origin.substring(idx, idx+1);
        int val = Integer.parseInt(temp);

        // 방문 확인
        if(!visited[val]) {
            visited[val] = true;
            // 다음 요소 탐색
            dfs(idx+1, max, answer + " " + temp);
            visited[val] = false;
        }

        // 만약 방문했고, idx가 조건에 맞다면 (idx+2 탐색을 위해)
        if(idx < origin.length()-1) {
            temp = origin.substring(idx, idx+2);
            val = Integer.parseInt(temp);
            if(val <= max && !visited[val]) {
                visited[val] = true;
                dfs(idx+2, max, answer + " " + temp);
                visited[val] = false;
            }
        }

    }

}
