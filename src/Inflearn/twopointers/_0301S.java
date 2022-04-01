package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1. 두 배열 합치기 - 솔루션 코드
public class _0301S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 기존의 합쳐서 정렬하는 풀이는 시간 복잡도가 O(nlogn).
        // two points를 사용하면 O(n)을 사용하도록 해보기

        int[] array1 = new int[n];

        for(int i=0; i<n; i++)
            array1[i] = Integer.parseInt(stk.nextToken());

        int m = Integer.parseInt(buf.readLine());
        int[] array2 = new int[m];

        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<m; i++)
            array2[i] = Integer.parseInt(stk.nextToken());

        List<Integer> answer = new ArrayList<>();

        // 포인터를 활용하기, 인덱스를 가리키는 것.
        int p1 = 0, p2 = 0;
        // 포인터가 배열의 끝까지 간다면 종료
        while(p1 <n && p2 < m) {
            // 작은 애들부터 차례로 넣어주기
            if(array1[p1] < array2[p2])
                // add 이후 p1 증가 (후위연산자)
                answer.add(array1[p1++]);
            else
                answer.add(array2[p2++]);
        }

        // 위의 while문이 종료되면 배열의 크기가 더 큰쪽은 남아있을 것이니까,
        // 남은 애들에 대해서 그냥 answer에 추가해주는 작업 진행해주기
        while(p1<n)
            answer.add(array1[p1++]);
        while(p2<m)
            answer.add(array2[p2++]);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }

    }
}
