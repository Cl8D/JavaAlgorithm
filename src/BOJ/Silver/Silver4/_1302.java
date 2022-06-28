package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 베스트셀러
public class _1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Map<String, Integer> book = new HashMap<>();

        for(int i=0; i<n; i++) {
            String name = buf.readLine();
            book.put(name, book.getOrDefault(name, 0)+ 1);
        };

        // 가장 큰 value 값
        // 나중에 key 기준으로 큰 값 찾을 때는 Collections.max(book.keySet()) 써주면 될 듯!
        Integer max = Collections.max(book.values());
        List<String> bookName = new ArrayList<>();
        for(String s : book.keySet()) {
            if(Objects.equals(book.get(s), max))
                bookName.add(s);
        }

        Collections.sort(bookName);
        buf2.write(bookName.get(0) + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

}