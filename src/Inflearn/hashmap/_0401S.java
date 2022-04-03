package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1. 학급 회장(해쉬) - 솔루션 코드
public class _0401S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        char[] stu = buf.readLine().toCharArray();

        Map<Character, Integer> student = new HashMap<>();

        for(char c : stu) {
            // getOrDefault를 사용하면
            // key에 해당하는 값이 없을 때 defaultValue로 채워주고,
            // 아니면 key에 해당하는 value 값을 세팅해준다.
            student.put(c, student.getOrDefault(c, 0)+1);
        }

        char answer = ' ';
        int max = 0;
        for(char key: student.keySet()) {
            if(student.get(key) > max) {
                max = student.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
