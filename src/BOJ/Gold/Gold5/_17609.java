package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 회문
public class _17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(buf.readLine());

        // 회문이면 0, 유사 회문이면 1, 둘 모두 아니면 2
        for (int i = 0; i < n; i++) {
            String target = buf.readLine();
            Position position = new Position(0, target.length() - 1);
            if (isPalindrome(target, position)) {
                sb.append("0").append(System.lineSeparator());
            } else if (isSimilarPalindrome(target, position)) {
                sb.append("1").append(System.lineSeparator());
            } else {
                sb.append("2").append(System.lineSeparator());
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static boolean isPalindrome(final String target, final Position position) {
        while (position.start <= position.end) {
            if (target.charAt(position.start) != target.charAt(position.end)) {
                return false;
            }
            position.start++;
            position.end--;
        }
        return true;
    }

    private static boolean isSimilarPalindrome(final String target, final Position position) {
        while (position.start <= position.end) {
            if (target.charAt(position.start) != target.charAt(position.end)) {
                if (isPalindrome(target, new Position(position.start + 1, position.end))) {
                    return true;
                }
                // end 제거하기
                if (isPalindrome(target, new Position(position.start, position.end - 1))) {
                    return true;
                }
                return false;
            }
            position.start++;
            position.end--;
        }
        return true;
    }

    static class Position {
        int start;
        int end;

        public Position(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
}
