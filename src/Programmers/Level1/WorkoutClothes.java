package Programmers.Level1;

import java.util.*;

// 체육복
class WorkoutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();
        for (int number : lost) {
            losts.add(number);
        }

        for (int number : reserve) {
            // 여벌 체육복을 가져온 학생이 도난당했을 경우, 해당 학생은 빌려줄 수가 없으니까 제거.
            if (losts.contains(number)){
                losts.remove((Object) number);
                continue;
            }
            reserves.add(number);
        }

        // 여분 체육복을 가져온 학생 정렬. 오름차순으로 되어 있어야 한다. 
        reserves.sort(Comparator.naturalOrder());

        // 초기 체육복을 입고있는 학생 수
        answer = n - losts.size();

        for (int number : reserves) {
            int minus = number - 1;
            int add = number + 1;
            boolean flag = false;

            if (losts.contains(number)) {
                continue;
            }

            if (losts.contains(minus)) {
                answer++;
                flag = true;
                losts.remove((Object) minus);
            }

            if (!flag && losts.contains(add)) {
                answer++;
                losts.remove((Object) add);
            }
        }
        return answer;
    }
}