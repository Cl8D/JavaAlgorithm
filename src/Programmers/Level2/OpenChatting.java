package Programmers.Level2;

import java.util.*;

public class OpenChatting {
    public String[] solution(String[] record) {
        StringTokenizer stk;
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(String s : record) {
            stk = new StringTokenizer(s);

            String motion = stk.nextToken();
            String uid = stk.nextToken();
            String name = "";

            if(stk.hasMoreTokens())
                name = stk.nextToken();

            String message = "";

            if(motion.equals("Enter")) {
                map.put(uid, name);
                message = uid + " " + "enter";
                result.add(message);
            }
            else if (motion.equals("Leave")) {
                message = uid + " " + "leave";
                result.add(message);
            }
            else {
                map.put(uid, name);
            }
        }

        String[] answer = new String[result.size()];
        int idx = 0;
        for(String s : result) {
            String[] mes = s.split(" ");

            if(map.containsKey(mes[0])) {
                if(mes[1].equals("enter"))
                    answer[idx++] = map.get(mes[0]) + "님이 들어왔습니다.";
                else
                    answer[idx++] = map.get(mes[0]) + "님이 나갔습니다.";
            }

        }


        return answer;
    }
}
