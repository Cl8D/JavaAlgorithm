package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 팰린드롬 만들기
public class _1213 {
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String str = buf.readLine();
        int length = str.length();
        count = new int[26];

        for(char c : str.toCharArray()) {
            int idx = c - 65;
            count[idx] += 1;
        }


        int odd = -1;

        // 만약, 문자 길이가 짝수인데 각 문자가 나온 개수 중에 홀수 개가 있으면 팰린드롬 X
        // 즉, 홀수 개인 게 없어야 한다는 것.
        if(length %2 == 0) {
            for (int i = 0; i < 26; i++) {
                if(count[i] % 2 == 1) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }
        }
        // 문자 길이가 홀수라면, 문자가 나온 개수가 홀수 개인 게 2개 이상이면 팰린드롬 x
        // 즉, 홀수 개인 게 무조건 1개여야 한다는 것.
        else {
            int temp = 0;
            for (int i = 0; i < 26; i++) {
                if(temp > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
                if(count[i] % 2 == 1) {
                    odd = i; // 홀수인 애 저장
                    temp++;
                }
            }
        }


        // 팰린드롬을 만들 수 있는 경우.
        // 사전순이라는 말에 꽂혀서 정렬을 해야 하나 싶었는데...
        // 생각해 보면 앞에서부터 차례대로 붙여주기만 하면 굳이 정렬할 필요가 없다.
        StringBuilder sb = new StringBuilder("");
        StringBuilder front = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            // 문자를 (개수/2)개만큼 붙여주기.
            // 어차피 앞뒤 뒤집어도 똑같으니 반만 만들어서 붙여주면 된다.
            for (int j = 0; j < count[i] / 2; j++) {
                front.append((char) (i + 65));
            }
        }
        sb.append(front);

        // 저장해뒀던 홀수도 붙여주기
        if(odd != -1) {
            String oddStr = String.valueOf((char)(odd+65));
            sb.append(oddStr);
        }

        // 뒤집은 거 붙여주기
        String reversed = front.reverse().toString();
        sb.append(reversed);

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

}

/*
// 완탐으로 풀었는데 답은 맞게 나오지만 메모리 초과가 나오는 코드.
// 문자열의 길이가 50 정도면 128MB 기준일 때 메모리 초과 난다는 거 생각해두기.
public class Main {
    static int length;
    static Set<String> set;
    static String str;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        str = buf.readLine();
        length = str.length();
        set = new HashSet<>();
        visited = new boolean[length];

        // 단순히 완탐으로 푸는 풀이법 - 메모리 초과 발생
        dfs(0, "");
        if(set.size() == 0) {
            buf2.write("I'm Sorry Hansoo");
        }
        else {
            List<String> sorted = new ArrayList<>(set);
            Collections.sort(sorted);
            buf2.write(sorted.get(0));
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void dfs(int level, String s) {
        if(level == length) {
            StringBuilder sb = new StringBuilder(s);
            if(s.equals(sb.reverse().toString())) {
                set.add(s);
            }
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level + 1, s + str.charAt(i));
                visited[i]= false;
            }
        }
    }
}


 */