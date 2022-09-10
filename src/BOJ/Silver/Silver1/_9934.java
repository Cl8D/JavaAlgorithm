package BOJ.Silver.Silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 완전 이진 트리
public class _9934 {
    static int[] val;
    static List<String>[] tree;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // cf) https://lotuslee.tistory.com/100
        // 전반적으로 트리 + 이진탐색까지 쓰이는 문제여서 이해하기 너무 힘들다... ㅎㅎ ㅠ

        // 트리의 깊이
        k = Integer.parseInt(buf.readLine());
        val = new int[(int)Math.pow(2, k) -1];

        // 트리의 깊이를 크기로 하는 arrayList 배열
        tree = new ArrayList[k];
        // 이런 식으로 초기화를 꼭 한 번 더 진행해줘야 한다는 점!
        // 내부가 string 형인 arrayList, 이게 배열 형태로 한 번 더 있는 거!
        for(int i=0; i<k; i++)
            tree[i] = new ArrayList<>();

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<val.length; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // 중위순회 진행하기
        inorder(0, val.length-1, 0);

        for(List<String> nodes: tree) {
            for(String s : nodes) {
                buf2.write(s);
            }
            buf2.write("\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void inorder(int start, int end, int level) {
        // 만약 level이 설정한 트리의 높이와 같다면 종료 (즉, k-1번째 높이까지 결과가 나온다)
        if(level == k)
            return;

        // 부모 노드
        int mid = (start + end) / 2;
        // 해당 레벨을 가지는 트리에 추가를 해주기
        tree[level].add(val[mid] + " ");

        inorder(start, mid-1, level+1);
        inorder(mid+1, end, level+1);

    }
}
