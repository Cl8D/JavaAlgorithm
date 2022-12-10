package Programmers.Level2;

import java.util.*;

// 메뉴 리뉴얼
class MenuRenewal {
    private static Map<String, Integer> menus = new HashMap<>();
    private static Map<Integer, HashSet<String>> menuCounts = new LinkedHashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // 이전 손님들이 주문할 때 가장 함께 많이 주문한 코스요리 메뉴로 구성하기.
        // 코스요리 -> 2가지 이상의 단품 메뉴
        // 2명 이상의 손님으로부터 주문된 조합만 후보.

        // orders -> 손님들이 주문한 단품메뉴
        // course -> 스카피가 추가하고 싶어하는 코스요리 구성 단품메뉴 개수
        for (String order : orders) {
            StringBuilder temp = new StringBuilder("");

            // 문자열을 먼저 정렬해놔야 한다.
            // 그래야 뒤에서 구할 때 AC, CA 같이 동일한 메뉴 조합에 대해서 다시 나오지 않게 된다.
            String[] partOrder = order.split("");
            Arrays.sort(partOrder);

            // 모든 경우의 수 다 만들어주기
            for (int i=0; i<course.length; i++) {
                createMenu(partOrder, 0, course[i], temp, 0);
            }
        }

        // 단품 메뉴의 개수별로 넣어두기
        for (String key : menus.keySet()) {
            int menuLength = key.length();
            HashSet<String> partMenus = menuCounts.getOrDefault(menuLength, new HashSet<>());
            partMenus.add(key);
            menuCounts.put(menuLength, partMenus);
        }


        List<String> answers = new ArrayList<>();
        // 개수에 대해서 가져오기
        for (int count : course) {
            List<String> maxOrderMenus = new ArrayList<>();
            int maxOrderCount = 0;

            HashSet<String> partMenus = menuCounts.get(count);
            if (partMenus == null) {
                continue;
            }

            for (String partMenu : partMenus) {
                int orderCount = menus.get(partMenu);

                // 주문 인원 수가 2명 이상이어야 하니까 패스.
                if (orderCount == 1) {
                    continue;
                }

                // 같으면 리스트에 추가
                if (maxOrderCount == orderCount) {
                    maxOrderMenus.add(partMenu);
                    continue;
                }
                // 더 크면 갱신
                if (maxOrderCount < orderCount) {
                    maxOrderCount = orderCount;
                    maxOrderMenus.clear();
                    maxOrderMenus.add(partMenu);
                }
            }
            answers.addAll(maxOrderMenus);

        }

        // 오름차순 정렬.
        answers.sort(Comparator.naturalOrder());
        answer = new String[answers.size()];
        int answerIdx = 0;
        for (String maxOrder : answers) {
            answer[answerIdx++] = maxOrder;
        }

        // answer -> 코스 요리 문자열, 배열, 사전순, 오름차순
        // 여러 개면 전부 담아서 리턴
        return answer;
    }


    private void createMenu(String[] order, int level, int max, StringBuilder temp, int start) {
        if (level == max) {
            String menu = temp.toString();
            menus.put(menu, menus.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i=start; i<order.length; i++) {
            temp.append(order[i]);
            createMenu(order, level+1, max, temp, i+1);
            temp.delete(level, level+1);
        }
    }
}