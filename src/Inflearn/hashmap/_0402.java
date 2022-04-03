package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2. 아나그램 (해쉬)
public class _0402 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        char[] c1 = buf.readLine().toCharArray();
        char[] c2 = buf.readLine().toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : c1) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for(char c : c2) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        boolean result = false;

        for(char key : map1.keySet()) {
            if(map2.containsKey(key)) {
                if(map1.get(key) == map2.get(key))
                    result = true;
                else {
                    result = false;
                    break;
                }
            }
        }

        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
