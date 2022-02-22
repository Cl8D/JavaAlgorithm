package Programmers.Level2;

import java.util.*;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i<clothes.length; i++) {
            map.put(clothes[i][0], clothes[i][1]);
        }

        // map에서 value 값만 가져온다
        Collection<String> values = map.values();

        // 옷의 종류를 중복되지 않도록 저장하는 set
        HashSet<String> valueSet = new HashSet<>(values);

        // hashSet을 List로 변경
        List<String> valueList = new ArrayList(valueSet);

        Map<String, Integer> clothCount = new HashMap<>();

        for(String cloth: valueList) {
            int cnt = 0;
            String clothType = "";
            for(String key: map.keySet()) {
                if(cloth.equals(map.get(key))) {
                    clothType = cloth;
                    cnt++;
                }
            }
            clothCount.put(clothType, cnt);
        }


        // 옷을 입을 수 있는 경우의 수
        // 만약 옷 종류가 2가지라면 0/1/2개 입는 경우의 수가 있다 -> 즉, 3가지
        for(String key: clothCount.keySet()) {
            answer *= (clothCount.get(key) + 1);
        }

        return answer-1;
    }

}

/*
근데 나처럼 푸는 건 정말 별로인 것 같고...
https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java
좋은 코드를 발견하였다.

1. 먼저 해시맵을 만든다.
이때 해시맵을 사용할 때 map.getOrDefault(key, 0)을 사용하였는데
이는 key값에 해당하는 value가 있으면 가져오고, 아니면 0을 리턴해주는 함수라고 한다.
여기서는, 옷의 종류 값을 key 값으로 둔 다음에,
해당 옷이 존재하지 않는다면 0으로 설정하고
옷이 존재한다면 기존의 값 + 1을 해주는 형태로 설계하였다.

for (String[] clothe : clothes) {
    String type = clothe[1];
    map.put(type, map.getOrDefault(type, 0) + 1);
}

-> 여기까지의 과정이 내가 정말 길게길게 풀어썼던 과정이다...

2. 옷을 입는 경우 / 입지 않은 경우가 존재하기 때문에 이를 염두하고 조합하기.
여기서 iterator를 사용하여 map의 value 값들을 넣어주었고,
해당 값들을 int형으로 바꾼다음 + 1을 하여 곱해준다. (여기서 더해지는 1이 옷을 입지 않은 경우)

Iterator<Integer> it = map.values().iterator();
int answer = 1;
while(it.hasNext())
    answer *= (it.next().intValue() + 1);

3. 그리고, 마지막에 아무 종류의 옷도 안 입을 때를 빼준다!



 */
