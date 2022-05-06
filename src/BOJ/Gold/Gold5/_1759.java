package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class _1759 {
    static int l, c;
    static char[] val;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        // 암호의 길이
        l = Integer.parseInt(stk.nextToken());
        // 암호로 사용했을 문자의 종류
        c = Integer.parseInt(stk.nextToken());

        // c개 중에서 l개 뽑기
        val = new char[c];
        visited = new boolean[c];

        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<c; i++) {
            val[i] = stk.nextToken().charAt(0);
        }

        Arrays.sort(val);

        // 최소 한 개의 모음, 두 개의 자음
        dfs(0, 0);

    }

    static void dfs(int level, int start) {
        if(level == l) {
            int vowel=0, consonants = 0;
            String result = "";

            for(int i=0; i<c; i++) {
                // 방문한 애들에 대해서
                if(visited[i]) {
                    result += val[i];

                    if(val[i] == 'a' || val[i] == 'e' || val[i] == 'i' || val[i] == 'o' || val[i] == 'u')
                        vowel++;
                    else
                        consonants++;
                }
            }

            if(vowel >= 1 && consonants >=2)
                System.out.println(result);


        } else {
            for(int i=start; i<c; i++) {
                visited[i] = true;
                // 자꾸... 실수해서 적어둠... start는 i+1, 그 다음 것부터 탐색하도록...! ㅠㅠ
                dfs(level + 1, i+1);
                visited[i] = false;
            }
        }
    }
}
