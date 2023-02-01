package Programmers.level4;

import java.util.*;

// 호텔 방 배정
class HotelRoom {

    private static final Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i=0; i<room_number.length; i++) {
            long room = room_number[i];
            long customerRoom = updateRoom(room);
            answer[i] = customerRoom;
        }

        System.out.println(map);

        return answer;
    }

    // 1 - 2 (X)
    // 3 - 4 (X)
    // 4 - 5 (X)
    // (1::2) 2 - 3, 기존값 갱신 (1 - 2)
    // (3::4) 5 - 6, 기존값 갱신 (4 - 5 / 3 - 5)
    // (1::2) 6 - 7, 기존값 갱신 (5 - 6 / 3 - 6 / 2 - 6 / 1 - 6)
    private long updateRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long parentRoom = map.get(room);
        long updateNum = updateRoom(parentRoom);
        // 기존 값 갱신해주기
        map.put(room, updateNum);
        return updateNum;
    }

}