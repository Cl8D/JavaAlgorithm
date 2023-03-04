package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 이진 검색 트리
public class _5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 후위 순회 : 왼 -> 오 -> 루트
        // 전위 순회: 루트 -> 왼 -> 오

        int value = Integer.parseInt(buf.readLine());
        Node tree = new Node(null, null, value);

        while (true) {
            String input = buf.readLine();
            if (input == null || input.isBlank() || input.isEmpty()) {
                break;
            }

            int v = Integer.parseInt(input);
            addNode(value, tree, v);
        }

        search(tree, sb);
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void addNode(final int targetValue, final Node target, final int value) {
        if (value < targetValue) {
            if (target.prev == null) {
                target.prev = new Node(value);
            } else {
                addNode(target.prev.value, target.prev, value);
            }
        } else {
            if (target.next == null) {
                target.next = new Node(value);
            } else {
                addNode(target.next.value, target.next, value);
            }
        }
    }

    private static void search(final Node node, final StringBuilder result) {
        if (node == null) {
            return;
        }
        // 전위 순회였으면 여기다가 넣어야 한다.
        // result.append(node.value).append(System.lineSeparator());
        search(node.prev, result);
        search(node.next, result);
        result.append(node.value).append(System.lineSeparator());
    }

    static class Node {
        Node prev;
        Node next;
        int value;

        public Node(final Node prev, final Node next, final int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        public Node(final int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}
