package Programmers.Level3;

import java.util.*;

// 디스크 컨트롤러
class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<DiskInfo> waitQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.processTime));

        int completeCount = 0;
        int currentTime = 0;
        int jobIdx = 0;

        // 1,4 | 7,9 | 1000,3
        while(completeCount < jobs.length) {
            // 작업의 시작 시간보다 현재 시간이 더 클 경우,
            // 아직 이전 작업이 진행 중인 거니까 (아니면 작업이 없는 초기거나) 대기 큐에 삽입.
            // = 현재 시간 이후에 시작되는 잡이 나타날 때까지 큐에 넣는다.
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                waitQueue.add(new DiskInfo(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }

            // 만약 대기 큐가 비어있으면 현재 작업에 대해서 작업 시간을 넣어준다.
            if (waitQueue.isEmpty()) {
                currentTime = jobs[jobIdx][0];
                continue;
            }

            // 그게 아니라면, 가장 수행 시간이 짧은 작업부터 진행하기
            DiskInfo current = waitQueue.poll();
            int currStartTime = current.startTime;
            int currProcessTime = current.processTime;

            answer += currProcessTime + currentTime - currStartTime;
            currentTime += currProcessTime;
            completeCount++;
        }

        int average = answer / jobs.length;
        return (int) Math.floor(average);
    }

    static class DiskInfo {
        int startTime;
        int processTime;

        public DiskInfo(int startTime, int processTime) {
            this.startTime = startTime;
            this.processTime = processTime;
        }
    }


}