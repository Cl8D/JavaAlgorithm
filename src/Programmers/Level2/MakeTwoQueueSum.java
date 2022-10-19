package Programmers.Level2;

import java.io.*;
import java.util.*;

public class MakeTwoQueueSum {
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;

            Queue<Integer> que1 = new LinkedList<>();
            Queue<Integer> que2 = new LinkedList<>();

            long sum1 = 0;
            long sum2 = 0;

            for(int i=0; i<queue1.length; i++) {
                que1.add(queue1[i]);
                sum1 += queue1[i];
            }

            for(int i=0; i<queue2.length; i++) {
                que2.add(queue2[i]);
                sum2 += queue2[i];
            }

            // test-case 11, 28번 때문에 while문으로 돌리면 틀린다...
            // 그래서 큐의 크기만큼만 그냥 반복문 돌아주기
            for (int i=0; i<3000001; i++) {
                if(que1.isEmpty() || que2.isEmpty()) {
                    answer = -1;
                    break;
                }

                if (sum1 < sum2) {
                    int v = que2.poll();
                    sum2 -= v;
                    que1.add(v);
                    sum1 += v;
                    answer++;
                } else if (sum1 > sum2) {
                    int v = que1.poll();
                    sum1 -= v;
                    que2.add(v);
                    sum2 += v;
                    answer++;
                } else {
                    break;
                }
                if (i== 3000000) {
                    answer = -1;
                }
            }


            return answer;
        }
    }
}
