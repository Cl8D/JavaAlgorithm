package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 단어 정렬
public class _1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        String[] word = new String[n];

        for(int i=0; i<n; i++) {
            word[i] = buf.readLine();
        }

        // comparator는 가끔 헷갈려서 ㅠㅠ 제대로 정리 한 번 해야 할 듯!!
        // https://blue-boy.tistory.com/182
        // 오름차순 정렬 = -1, 내림차순 = 1, 같을 때 0인 느낌
        // compareTo는 아스키로 비교하니까 오름차순 -1, 내림차순 1

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()) // 길이 기준 오름차순 정렬
                    return -1;
                else if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return 1;
            };
        });

        // 중복 제거 + 순서 보장
        Set<String> result = new LinkedHashSet<>(Arrays.asList(word));
        for(String s : result)
            buf2.write(s + "\n");


        buf2.flush();

        buf.close();
        buf2.close();
    }
}
