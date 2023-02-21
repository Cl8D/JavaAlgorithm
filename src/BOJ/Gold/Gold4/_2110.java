package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 공유기 설치
public class _2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        // 집의 개수
        int n = Integer.parseInt(stk.nextToken());

        // 공유기의 개수
        int c = Integer.parseInt(stk.nextToken());

        // 집의 좌표
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(buf.readLine());
        }

        // 이분 탐색을 활용하면 시간 복잡도를 O(NlogX)로 줄일 수 있다.
        // 가장 인접한 공유기의 사이를 가능한 크게 하기 = 최대 거리 구하기.
        // 인접한 두 공유기 사이의 거리를 대략적으로 예상할 필요가 있는데, 이를 위해 이분 탐색을 이용하기.
        Arrays.sort(houses);

        int answer = 0;

        // 1 2 4 8 9
        int start = 1; // 공유기의 최소 거리
        int end = houses[n-1] - houses[0]; // 최대 거리

        while (start <= end) {
            // 인접한 두 공유기의 거리 (중간값 구하기)
            int mid = (start + end) / 2;

            // 첫 번째 집에는 반드시 공유기를 설치한다.
            int count = 1;
            // 직전에 공유기를 설치한 위치
            int prevPosition = houses[0];

            // mid를 기준으로 공유기를 설치할 수 있는 집의 개수를 찾는다.
            for (int i = 1; i < n; i++) {
                int distance = houses[i] - prevPosition;
                if (distance >= mid) { // 더 먼 경우
                    count++;
                    prevPosition = houses[i];
                }
            }

            // 공유기를 설치할 수 있다면, 거리를 더 늘려서 최댓값을 찾는다.
            if (count >= c) {
                answer = mid;
                start = mid + 1;
            } else { // 설치할 수 없다면 거리를 줄인다.
                end = mid - 1;
            }
        }
        System.out.println(answer);


        buf2.flush();
        buf.close();
        buf2.close();
    }
}