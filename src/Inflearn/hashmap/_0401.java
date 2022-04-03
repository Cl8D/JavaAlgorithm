package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1. 학급 회장(해쉬)
public class _0401 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        char[] stu = buf.readLine().toCharArray();

        Map<Character, Integer> student = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!student.containsKey(stu[i]))
                student.put(stu[i], 0);
            else
                student.put(stu[i], student.get(stu[i]) + 1);
        }

        int max = 0;
        char result = 'a';

        for (char key : student.keySet()) {
            int before_max = max;
            max = Math.max(max, student.get(key));

            if (before_max < max)
                result = key;
        }

        System.out.println(result);
    }
}
