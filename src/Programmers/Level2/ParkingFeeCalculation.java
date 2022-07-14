package Programmers.Level2;

import java.io.*;
import java.util.*;

// 주차 요금 계산
public class ParkingFeeCalculation {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int[] fees = {180, 5000, 10, 600};
        // 시각, 차량 번호, 내역
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        // 차랑번호, 시간
        Map<String, String> fee = new HashMap<>();
        // 차량번호, 계산된 시간
        Map<String, Integer> ans = new HashMap<>();

        for (String s : records) {
            stk = new StringTokenizer(s);
            String time = stk.nextToken();
            String number = stk.nextToken();

            // 입차
            if(stk.nextToken().equals("IN"))
                fee.put(number, time);

                // 출차
            else {
                int resultTime = computeTime(time) - computeTime(fee.get(number));
                // 같은 차는 여러 번 들어올 수 있기 때문에 이미 들어온 경우에 대해서도 생각해주기
                ans.put(number, resultTime + ans.getOrDefault(number, 0));
                // 입차 - 출차가 온전히 되었을 경우 맵에서 제거
                fee.remove(number);
            }
        }

        // 출차 없이 단순히 입차만 된 경우 - 23:59를 출차라고 계산
        if (!fee.isEmpty()) {
            for (String key : fee.keySet()) {
                int resultTime = (24*60-1) - computeTime(fee.get(key));
                ans.put(key, resultTime + ans.getOrDefault(key, 0));
            }
        }

        // 요금 계산 - 마지막에 한 번에 진행해줘야 함
        for (String number : ans.keySet()) {
            int time = ans.get(number);
            int resultFee = 0;
            // 기본 시간보다 작은 경우 그냥 기본 요금 지불
            if (time <= fees[0])
                resultFee = fees[1];
            else
                // 아니라면 계산
                resultFee = fees[1] + (int)Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            ans.put(number, resultFee);
        }

        // 차랑번호가 작은 순으로 정렬
        ArrayList<String> keys = new ArrayList<>(ans.keySet());
        Collections.sort(keys);

        int[] answer = new int[keys.size()];
        int idx = 0;
        for(String k : keys) {
            answer[idx++] = ans.get(k);
        }


        System.out.println(Arrays.toString(answer));
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static int computeTime(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}
