package Programmers.Level1;
import java.util.*;
import java.io.*;

// 신고 결과 받기
public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        StringTokenizer stk;

        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> info = new HashMap<>();

        for(String s : report) {
            stk = new StringTokenizer(s);
            String a = stk.nextToken();
            String b = stk.nextToken();

            Set<String> name;

            // 신고자에 대한 정보 관리
            Set<String> getNames = info.get(a);
            if(getNames == null) {
                name = new HashSet<>();
            }
            else {
                name = getNames;
            }
            name.add(b);
            info.put(a, name);
        }


        for(Set<String> name : info.values()) {
            for(String s : name) {
                reportCount.put(s, reportCount.getOrDefault(s, 0) + 1);
            }
        }

        Map<String, Integer> ans = new LinkedHashMap<>();
        for(String s : id_list)
            ans.put(s, ans.getOrDefault(s, 0));

        for(String s : reportCount.keySet()) {
            if(reportCount.get(s) >= k) {
                for(String id : id_list) {
                    if (info.containsKey(id) && info.get(id).contains(s)) {
                        ans.put(id, ans.get(id) + 1);
                    }
                }
            }
        }

        int[] answer = new int[id_list.length];
        int idx = 0;
        for(String s : ans.keySet())
            answer[idx++] = ans.get(s);

        return answer;
    }
}
