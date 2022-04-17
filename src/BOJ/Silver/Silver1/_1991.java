package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회 - 나중에 다시 풀어보기
public class _1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        // 새로운 tree 객체 생성 (1개 그대로 유지)
        Tree tree = new Tree();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            char root = stk.nextToken().charAt(0);
            char left = stk.nextToken().charAt(0);
            char right = stk.nextToken().charAt(0);

            tree.createNode(root, left, right);
        }

        // 각각 전위, 중위, 후위 순위 진행
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}

class Node {
    char data;
    Node left, right;

    public Node(char data){
        this.data = data;
    }
}


class Tree {
    public Node root;

    public void createNode(char data, char left, char right) {
        if (root == null) {
            // 가장 처음에 들어온 게 tree 클래스의 root가 되는 것
            root = new Node(data);
            if(left == '.')
                root.left = null;
            else
                root.left = new Node(left);

            if(right == '.')
                root.right = null;
            else
                root.right = new Node(right);
        }
        else {
            // 루트 이후에 들어오는 자식 노드들이 서로 연결되도록
            // 루트 정보를 함께 넘겨준다.
            searchNode(root, data, left, right);
        }
    }

    public void searchNode(Node node, char data, char left, char right) {
        if(node == null)
            return;
            // 각각의 노드를 트리에 연결해주는 부분.
            // 각 노드의 루트에 있는 data가 트리에 존재하는지 확인하는 부분
        else if (node.data == data) {
            if(left == '.')
                node.left = null;
            else
                node.left = new Node(left);

            if(right == '.')
                node.right = null;
            else
                node.right = new Node(right);
        }
        else {
            // 만약 node가 null아 아니면서 data가 아닌 경우,
            // 해당 node의 left, right에 대한 연결 시도
            // (자식들에 대해 연결해주기 위함)
            // 어차피 이게 호출되는 시점에서는 루트인 A를 거치고,
            // 루트의 자식인 B, C... 이런 식으로 순차적으로 호출되기 때문에
            // B나 C에 대한 자식들이 입력으로 받아졌을 때 연결되게 해주려고 재귀호출 하는 느낌임!
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    // 전위 순회
    // 루트 -> 왼쪽 -> 오른쪽
    // ABDCEFG
    public void preOrder(Node node) {
        System.out.print(node.data);
        if(node.left!=null)
            preOrder(node.left);
        if(node.right!=null)
            preOrder(node.right);
    }

    // 중위 순회
    // 왼쪽 -> 루트 -> 오른쪽
    // DBAECFG
    public void inOrder(Node node){
        if(node != null) {
            if(node.left!=null)
                inOrder(node.left);
            System.out.print(node.data);
            if(node.right!=null)
                inOrder(node.right);
        }
    }

    // 후위 순회
    // 왼쪽 -> 오른쪽 -> 루트
    // DBEGFCA
    public void postOrder(Node node){
        if(node != null) {
            if(node.left!=null)
                postOrder(node.left);
            if(node.right!=null)
                postOrder(node.right);
            System.out.print(node.data);
        }
    }

}

