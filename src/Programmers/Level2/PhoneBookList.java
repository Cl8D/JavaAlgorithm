package Programmers.Level2;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> phone = new HashMap<String, Integer>();

        for (int i=0; i<phone_book.length; i++) {
            phone.put(phone_book[i], i);
        }


        // String[] 배열의 길이를 탐색할 때는 .length
        // String 문자열 하나의 길이를 탐색할 때는 .length()
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j< phone_book[i].length(); j++) {
                // 해시맵 기능 중에 하나.
                // 해시맵에 containsKey의 파라미터가 존재하는지 확인 가능!
                // 접두사 = 해당 문자열의 길이만큼 탐색
                if(phone.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }


        return answer;
    }
}
