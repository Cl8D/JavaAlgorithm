package Programmers.Level1;

// 키패드 누르기
class PushKeyPad {
    private static final int THREE = 3;
    private static final String LEFT = "left", RIGHT = "right";
    private static final String L = "L", R = "R";

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10, right = 12;

        for (int number : numbers) {
            // 왼손이 누를 수 있는 경우
            if (number % THREE == 1) {
                answer.append(L);
                left = number;
                continue;
            }
            // 오른손이 누를 수 있는 경우
            if (number != 0 && number % THREE == 0) {
                answer.append(R);
                right = number;
                continue;
            }

            // 더 가까운 엄지손가락 사용하기
            int leftDis = getDistance(left, number);
            int rightDis = getDistance(right, number);

            // 같을 경우 이사람의 특성에 따라서
            if (leftDis == rightDis) {
                if (hand.equals(RIGHT)) {
                    answer.append(R);
                    right = number;
                } else {
                    answer.append(L);
                    left = number;
                }
                continue;
            }

            if (leftDis > rightDis) {
                answer.append(R);
                right = number;
                continue;
            }

            answer.append(L);
            left = number;
        }
        return answer.toString();
    }

    private int getDistance(int current, int dest) {
        int[] curPoint = getPoint(current);
        int[] destPoint = getPoint(dest);

        return Math.abs(curPoint[0]-destPoint[0]) + Math.abs(curPoint[1]-destPoint[1]);
    }

    // (1,1)(1,2)(1,3)
    // (2,1)(2,2)(2,3)
    // (3,1)(3,2)(3,3)
    // (4,1)(4,2)(4,3)
    private int[] getPoint(int value) {
        if (value == 0) {
            return new int[]{4, 2};
        }
        if (value % THREE == 1) {
            return new int[]{value/THREE + 1, 1};
        }
        if (value % THREE == 0) {
            return new int[]{value/THREE, 3};
        }
        return new int[]{value/THREE+1, 2};
    }
}