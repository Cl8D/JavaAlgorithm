package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 통계학
public class _2103 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String s = buf.readLine();
            val[i] = Integer.parseInt(s);
            map.put(val[i], map.getOrDefault(val[i], 0) +1);
        }

        // 산술평균 - 합의 최대가 500000*4000 = 2,000,000,000이니까 int 범위 안 넘음!
        int sum = Arrays.stream(val).sum();
        buf2.write(Math.round((double)sum / n)+"\n");

        // 중앙값
        Arrays.sort(val);
        buf2.write(val[n/2]+"\n");

        // 최빈값
        Integer max = Collections.max(map.values());
        List<Integer> maxVal = new ArrayList<>();

        for(Integer v : map.keySet()) {
            if(Objects.equals(map.get(v), max))
                maxVal.add(v);
        }

        Collections.sort(maxVal);

        if(maxVal.size()==1) // 1개면 어차피 두 번째로 작은 값이 첫 번째로 작은 값임
            buf2.write(maxVal.get(0) + "\n");
        else
            buf2.write(maxVal.get(1) + "\n");

        // 범위
        int range = Collections.max(map.keySet()) - Collections.min(map.keySet());
        buf2.write(range+"\n");

        buf2.flush();
        buf.close();
        buf2.close();

    }

}

