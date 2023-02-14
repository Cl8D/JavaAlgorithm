package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 문자열 생성
public class _6137 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(buf.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = buf.readLine();
        }

        int start = 0, end = n - 1;

        // 개행의 개수
        int newLineCount = 0;

        // 첫 개행 로직 검증했는지
        boolean isFirst = false;
        while (answer.length() - newLineCount < n) {
            String front = words[start];
            String back = words[end];

            // A - B
            if (front.compareTo(back) < 0) {
                answer.append(front);
                start++;
            } else if (front.compareTo(back) > 0) {
                answer.append(back);
                end--;
            } else {
                int tempStart = start + 1;
                int tempEnd = end - 1;

                if (tempStart >= n || tempEnd < 0) {
                    answer.append(words[start]);
                    start++;
                    continue;
                }

                while (tempStart < n-1 && tempEnd > 0) {
                    if (!words[tempStart].equals(words[tempEnd])) {
                        break;
                    }
                    tempStart++;
                    tempEnd--;
                }

                if (words[tempStart].compareTo(words[tempEnd]) < 0) {
                    answer.append(front);
                    start++;
                } else {
                    answer.append(back);
                    end--;
                }
            }

            if (answer.length() == 80) {
                isFirst = true;
                newLineCount++;
                answer.append("\n");
                continue;
            }

            if (isFirst && (answer.length() - newLineCount) % 80 == 0) {
                newLineCount++;
                answer.append("\n");
            }
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}