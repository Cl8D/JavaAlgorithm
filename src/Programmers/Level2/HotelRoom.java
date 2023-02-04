package Programmers.Level2;

import java.util.*;

// 호텔 대실
class HotelRoom {
    // 24 * 60 + 10. (청소 시간 포함)
    private static final int MAX_TIME =  1450;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;

        // 누적합 이용하기 : 시작 위치에 + 1, 끝 위치에 -1.
        // 현재 위치에 이전 위치의 값을 더해주기.

        // 겹치는 시간대에 대해서 +1을 하게 된다.
        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String startTime = time[0];
            String endTime = time[1];

            // 입실 시간에 +1 <시작>
            rooms[convertTime(startTime)] += 1;
            // 퇴실 + 청소 시간에 -1 <끝>
            rooms[convertTime(endTime) + CLEAN_TIME] -= 1;
        }

        for (int i=1; i< MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    private int convertTime(String time) {
        String[] times = time.split(":");
        int[] convertTimes = new int[2];
        convertTimes[0] = Integer.parseInt(times[0]);
        convertTimes[1] = Integer.parseInt(times[1]);
        return convertTimes[0] * HOUR + convertTimes[1];
    }
}