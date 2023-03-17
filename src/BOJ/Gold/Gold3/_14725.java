package BOJ.Gold.Gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 개미굴
public class _14725 {
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 먹이 정보 개수
        int n = Integer.parseInt(buf.readLine());

        Food root = new Food();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int count = Integer.parseInt(stk.nextToken());

            Food current = root;
            for (int j = 0; j < count; j++) {
                String child = stk.nextToken();
                if (!current.childs.containsKey(child)) {
                    current.childs.put(child, new Food());
                }
                current = current.childs.get(child);
            }
        }

        print(root, 0);
        System.out.println(answer);

        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void print(Food food, int depth) {
        List<String> keys = food.childs.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (String key : keys) {
            answer.append("--".repeat(depth))
                    .append(key)
                    .append(System.lineSeparator());
            Food subChild = food.childs.get(key);
            print(subChild, depth + 1);
        }
    }

    static class Food {
        Map<String, Food> childs = new HashMap<>();

        @Override
        public String toString() {
            return "Food{" + System.lineSeparator() +
                    "childs=" + childs + System.lineSeparator() +
                    '}' + System.lineSeparator();
        }
    }


    /**
     * B -> A -> B -> C -> D
     *        -> C
     */
}
