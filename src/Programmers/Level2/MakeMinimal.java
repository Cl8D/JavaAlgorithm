package Programmers.Level2;

import java.util.*;

// 최솟값 만들기
class MakeMinimal
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        List<Integer> bList = new ArrayList<>();
        for (int b : B) {
            bList.add(b);
        }
        Collections.sort(bList, (o1, o2) -> {
            return o2 - o1;
        });

        for (int i=0; i<A.length; i++) {
            answer += A[i] * bList.get(i);
        }

        return answer;
    }
}