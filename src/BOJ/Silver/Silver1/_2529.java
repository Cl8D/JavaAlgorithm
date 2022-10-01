package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 부등호
public class _2529 {
    static int k;
    static String[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        k = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        sign = new String[k];

        for (int i = 0; i < k; i++) {
            sign[i] = stk.nextToken();
        }

        // 백트래킹 / 완전탐색으로 진행 (어차피 k의 범위가 매우 작음)
        dfs(0, "");

        // 어차피 완전탐색으로 가장 작은 값부터 탐색을 진행하니까 별도의 소팅 작업 필요없이
        // 처음 값이 최소고, 마지막 값이 최댓값이 된다.
        sb.append(answer.get(answer.size()-1)).append("\n").append(answer.get(0));
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs(int depth, String temp) {
        if (depth == k+1) {
            // 탐색 완료 시 값 넣어두기
            answer.add(temp);
            return;
        }
        // 여기서 탐색하는 i가 곧 부등호 뒤에 들어갈 수 있는 숫자에 대한 탐색 (0~9)
        for (int i = 0; i <= 9; i++) {
            if(depth == 0) { // depth=0일 때는 어차피 초기값니까 별다른 조건 비교 x
                visited[i] = true;
                dfs(depth+1, temp + i);
                visited[i] = false;
            } else {
                if (!visited[i]) {
                    // temp에 붙은 글자 중에서 가장 마지막 숫자 가져오기
                    int val = Character.getNumericValue(temp.charAt(temp.length() - 1));

                    // 부등호는 숫자 사이에 있으니까 위치가 depth-1 위치에 있는 게 기준
                    String s = sign[depth - 1];
                    // 부등호가 < 라면 마지막 값보다 현재 탐색 중인 값이 커야 하고
                    // > 라면 마지막 값보다 현재 탐색 중인 값이 작아야 함
                    // temp = 0이라면 0 < ? 일 때 ?는 0보다 커야 하고 0 > ?라면 0보다 작아야 하니까
                    if ((s.equals("<") && val < i) || (s.equals(">") && val > i)) {
                        // 조건에 맞으면 백트래킹을 통해 모든 경우 탐색 시작
                        visited[i] = true;
                        dfs(depth+1, temp+i);
                        visited[i]= false;
                    }
                }
            }
        }
    }


}