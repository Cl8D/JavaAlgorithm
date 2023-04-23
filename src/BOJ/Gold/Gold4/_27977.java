package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 킥보드로 등교하기
public class _27977 {
    private static int l, n, k;
    private static int[] locations;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        // 학교까지의 거리
        l = Integer.parseInt(stk.nextToken());
        // 킥보드 충전소의 개수
        n = Integer.parseInt(stk.nextToken());
        // 최대 충전소 방문 횟수
        k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        locations = new int[n];
        for (int i = 0; i < n; i++) {
            locations[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0;
        int start = 1, end = l;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (canMove(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
        buf.close();
    }
    private static boolean canMove(final int capacity) {
        int current = 0;
        int count = 0;
        int usedCapacity = 0;

        for (int i = 0; i < n; i++) {
            int distance = locations[i] - current;
            if (distance > capacity) {
                return false;
            }
            usedCapacity += distance;

            // 다 사용했다면 무조건 충전
            if (usedCapacity == capacity) {
                count++;
                usedCapacity = 0; // 충전했으니 사용량 초기화
            } else if (usedCapacity > capacity) {
                // 사용한 양이 더 많다면 이전의 충전소에서 무조건 충전해야 함
                count++;
                // 이전 충전소에서 충전 후, 이동했다고 가정
                usedCapacity = distance;
            }
            current = locations[i];
        }

        // 도착지까지 남은 거리
        int remainDistance = l - current;
        if (remainDistance > capacity) {
            return false;
        }

        // 사용한 용량 + 남은 거리가 더 크면 배터리 충전 필요 (이전 충전소에서 충전했다고 가정)
        if (remainDistance + usedCapacity > capacity) {
            count++;
        }

        // 최대 충전 가능 횟수만큼만 충전했는지 체크
        return count <= k;
    }
}
