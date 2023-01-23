package Programmers.Level2;

// 택배 배달과 수거하기
class DeliveryAndCollect {
    private static long answer = 0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 초기값은 인덱스로 맞춰주기
        n--;

        while(n >= 0) {
            // 초기에 방문할 곳의 택배 상자가 0이면 그냥 패스.
            if (deliveries[n] == 0 && pickups[n] == 0) {
                n--;
                continue;
            }

            int deliveryIdx = visitHome(n, deliveries, cap);
            int pickupIdx = visitHome(n, pickups, cap);
            if (deliveries[deliveryIdx] == 0 && pickups[pickupIdx] == 0) {
                break;
            }
            n = Math.max(deliveryIdx, pickupIdx);
        }
        return answer;
    }

    private int visitHome(int n, int[] map, int cap) {
        int lastIdx = 0;
        int curBox = 0;

        for (int i=n; i>=0; i--) {
            curBox += map[i];
            if (curBox > cap) {
                curBox -= map[i];
                // 원하는 만큼 옮길 수 있기 때문에 남은 값만큼 갱신해주기
                map[i] -= (cap - curBox);
                lastIdx = i;
                break;
            }
            map[i] = 0;
            lastIdx = i;
        }

        answer += (n + 1);

        return lastIdx;
    }

}