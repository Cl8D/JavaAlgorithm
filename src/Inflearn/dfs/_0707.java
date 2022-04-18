package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7. 이진트리 레벨탐색(BFS)
public class _0707 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 입력 예시
        /*
        7
        1 2 3
        2 4 5
        3 6 7
        4 0 0
        5 0 0
        6 0 0
        7 0 0
         */

        Tree2 tree = new Tree2();

        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int root = Integer.parseInt(stk.nextToken());
            int left = Integer.parseInt(stk.nextToken());
            int right = Integer.parseInt(stk.nextToken());

            tree.createNode(root, left, right);
        }

        tree.bfs(tree.root);

    }
}

class Node2 {
    int data;
    Node2 left;
    Node2 right;

    public Node2(int data) {
        this.data = data;
    }
}

class Tree2 {
    public Node2 root;

    public void createNode(int data, int left, int right) {
        if(root == null) {
            // 예제만 들어가도록 설계
            root = new Node2(data);
            root.left = left==0 ? null : new Node2(left);
            root.right = right==0 ? null : new Node2(right);
        }
        else {
            searchNode(root, data, left, right);
        }
    }

    public void searchNode(Node2 node, int data, int left, int right) {
        if(node == null) {
            return;
        } else if(node.data == data) {
            node.left = left==0 ? null : new Node2(left);
            node.right = right==0 ? null : new Node2(right);
        }
        else {
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    // 레벨순으로 탐색을 진행한다.
    // 루트 - 그 다음 레벨 = 그 다음 레벨 탐색...
    // 큐를 이용해서 구현한다.
    public void bfs(Node2 root) {
        // node형 데이터를 담는 큐를 만든다.
        Queue<Node2> queue = new LinkedList<>();
        // 가장 처음에는 루트 노드가 들어간다.
        queue.add(root);
        int level = 0; // 레벨

        while(!queue.isEmpty()) {
            // 큐의 사이즈 = 해당 레벨에 있는 데이터의 수라고 생각할 수 있다.
            int len = queue.size();
            System.out.println("Level = " + level);
            System.out.println("data count in current level = " + len);

            // 해당 레벨에 해당하는 원소들을 다 출력하는 형태
            for(int i=0; i<len; i++) {
                Node2 current = queue.poll();
                System.out.print(current.data + " ");

                // 해당 노드의 다음 레벨 (자식 노드들을 큐에 넣는다)
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            level++;
            System.out.println();
        }

    }
}


