package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 대소문자 구분 x
        for(int i=0; i<cities.length; i++)
            cities[i] = cities[i].toLowerCase();

        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            // cache hit
            if(queue.contains(cities[i])) {
                int cnt = 0;
                int size = queue.size();
                while(cnt < size) {
                    if(!queue.isEmpty() && queue.peek().equals(cities[i]))
                        queue.poll();
                    else
                        queue.add(queue.poll());
                    cnt++;
                }
                queue.add(cities[i]);
                answer += 1;
            }
            // cache miss
            else {
                if (queue.size() < cacheSize)
                    queue.add(cities[i]);
                else {
                    queue.poll();
                    queue.add(cities[i]);
                }
                answer += 5;
            }
        }

        // 캐시 사이즈가 0이라면 계속 miss가 난다!
        if(cacheSize == 0)
            return 5 * cities.length;
        else
            return answer;
    }
}
