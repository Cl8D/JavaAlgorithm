package Inflearn.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 5. K번째 큰 수
public class _0405 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        int[] card = new int[n];

        for(int i =0; i<n; i++)
            card[i] = Integer.parseInt(stk.nextToken());

        Set<Integer> sum = new HashSet<>();

        int temp = 0;
        // 카드 3장 뽑기
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int p=j+1; p<n; p++) {
                    temp = card[i] + card[j] + card[p];
                    sum.add(temp);
                }
            }
        }

        // 아예 처음 선언 때부터 이런 식으로 선언하면
        // 정렬된 sum으로 저장된다.
        // Set<Integer> sum = new TreeSet<>(Collections.reverseOrder());
        // 근데 이러면 get 이런 게 안 먹어서... 사실 좋은지 잘 모르겠음.

        List<Integer> sumList = new ArrayList<>(sum);
        Collections.sort(sumList, Collections.reverseOrder());

        if(sumList.size() < k)
            System.out.println("-1");
        else
            System.out.println(sumList.get(k-1));




    }
}
