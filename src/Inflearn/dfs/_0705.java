package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5. 이진트리 순회
public class _0705 {public static void main(String[] args) throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;
    int n = Integer.parseInt(buf.readLine());
        /*
            입력 예시)
            1 2 3
            2 4 5
            3 6 7
            4 0 0
            5 0 0
            6 0 0
            7 0 0
         */

    Tree tree = new Tree();

    for(int i=0; i<n; i++) {
        stk = new StringTokenizer(buf.readLine());
        int root = Integer.parseInt(stk.nextToken());
        int left = Integer.parseInt(stk.nextToken());
        int right = Integer.parseInt(stk.nextToken());

        tree.createNode(root, left, right);
    }

    tree.preOrder(tree.root);
    System.out.println();
    tree.inOrder(tree.root);
    System.out.println();
    tree.postOrder(tree.root);
    System.out.println();
}
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void createNode(int data, int left, int right) {
        if(root == null) {
            root = new Node(data);
            root.left = (left == 0 ? null : new Node(left));
            root.right = (right == 0 ? null : new Node(right));
        }

        else {
            searchNode(root, data, left, right);
        }
    }

    public void searchNode(Node node, int data, int left, int right) {
        if(node == null) {
            return;
        }
        else if(node.data == data){
            node.left = (left==0 ? null : new Node(left));
            node.right = (right==0 ? null : new Node(right));
        }
        else {
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    // 전위) 루트 > 왼쪽 > 오른쪽
    public void preOrder(Node node) {
        System.out.print(node.data + " ");
        if(node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    // 중위) 왼쪽 > 루트 > 오른쪽
    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null)
                inOrder(node.left);
            System.out.print(node.data + " ");
            if (node.right != null)
                inOrder(node.right);
        }
    }

    // 후위) 왼쪽 > 오른쪽 > 루트
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null)
                postOrder(node.left);
            if(node.right != null)
                postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }




}