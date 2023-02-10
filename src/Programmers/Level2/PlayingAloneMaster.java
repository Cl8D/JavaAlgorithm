package Programmers.Level2;

import java.util.*;

// 혼자 놀기의 달인
class PlayingAloneMaster {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public int solution(int[] cards) {
        for (int i=0; i<cards.length; i++) {
            map.put(cards[i], i+1);
        }

        boolean[] visited = new boolean[cards.length+1];
        List<Integer> boxes = new ArrayList<>();
        for (int card : cards) {
            if (visited[card]) {
                continue;
            }
            boxes.add(pickCard(card, visited, 1));
            // boxes.add(pickCard(card, visited) + 1);
        }

        if (boxes.size() == 1) {
            return 0;
        }

        boxes.sort(Comparator.reverseOrder());

        return boxes.get(0) * boxes.get(1);
    }

    private int pickCard(int firstCard, boolean[] visited, int box) {
        visited[firstCard] = true;

        int nextCard = map.get(firstCard);
        if (visited[nextCard]) {
            return box;
        }
        return pickCard(nextCard, visited, ++box);
    }

    // 이렇게 푸는 게 더 좋다.
    private int pickCard(int firstCard, boolean[] visited) {
        visited[firstCard] = true;

        int nextCard = map.get(firstCard);
        if (visited[nextCard]) {
            return 0;
        }
        return pickCard(nextCard, visited) + 1;
    }
}