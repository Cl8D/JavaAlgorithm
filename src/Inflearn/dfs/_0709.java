package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// tree 말단 노드까지 가장 짧은 경로
public class _0709 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        /*
            입력 예시
            5
            1 2 3
            2 4 5
            3 0 0
            4 0 0
            5 0 0
         */

        Tree3 tree= new Tree3();
        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int root = Integer.parseInt(stk.nextToken());
            int left = Integer.parseInt(stk.nextToken());
            int right = Integer.parseInt(stk.nextToken());

            tree.createNode(root, right, left);
        }

        System.out.println(tree.bfs(tree.root));
        System.out.println(tree.dfs(tree.root, 0));
    }
}

class Node3 {
    int data;
    Node3 lt;
    Node3 rt;

    public Node3(int data){
        this.data = data;
    }
}

class Tree3 {
    public Node3 root;

    public void createNode(int data, int left, int right) {
        if (root == null) {
            root = new Node3(data);
            root.lt = left == 0 ? null : new Node3(left);
            root.rt = right == 0 ? null : new Node3(right);
        }
        else
            searchNode(root, data, left, right);

    }

    public void searchNode(Node3 node, int data, int left, int right) {
        if (node == null)
            return;
        else if (node.data == data) {
            node.lt = left == 0 ? null : new Node3(left);
            node.rt = right == 0 ? null : new Node3(right);
        }
        else {
            searchNode(node.lt, data, left, right);
            searchNode(node.rt, data, left, right);
        }
    }

    public int bfs(Node3 node) {
        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);

        int level = 0;
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                Node3 current = queue.poll();

                if(current.lt == null && current.rt == null)
                    return level+1;

                if(current.lt != null)
                    queue.add(current.lt);
                if(current.rt != null)
                    queue.add(current.rt);
            }
            level++;
        }
        return 0;
    }


    public int dfs(Node3 node, int level) {
        // 말단 노드인지 확인
        if(node.lt==null && node.rt==null)
            return level;
        else
            // 왼쪽-오른쪽 자식으로 뻗어나가기
            // 최단거리니까 더 작은 값을 넣어주는 것
            return Math.min(dfs(node.lt, level+1), dfs(node.rt, level+1));
    }

    /*
        D(1) -> min(D(2), D(3)) = 1
        --> D(2) -> min(D(4), D(5)) = 2
        ------> D(4) -> return 2;
        ------> D(5) -> return 2;
        --> D(3) -> return 1
     */


}