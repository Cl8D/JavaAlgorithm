package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 올림픽
public class _8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 금메달 수가 더 많은 나라
        // 금메달 수가 같으면 은메달 수
        // 금, 은메달 수가 같으면 동메달이 더 많은 나라

        // 등수는 자신보다 더 잘한 나라 수 + 1
        // 모든 메달 수가 같으면 등수는 동일
        // 공동 n등이 있으면 그 다음 순위는 그 만큼 밀린 걸로

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        List<Medal> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 국가 코드
            int country = Integer.parseInt(stk.nextToken());
            int gold = Integer.parseInt(stk.nextToken());
            int sliver = Integer.parseInt(stk.nextToken());
            int bronze = Integer.parseInt(stk.nextToken());

            list.add(new Medal(country, gold, sliver, bronze));
        }

        list.sort((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                }
                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        // 가장 처음 나라의 등수는 1등
        list.get(0).rank = 1;

        // k번째 국가의 인덱스를 저장해둔다.
        int temp = 0;

        for (int i = 1; i < list.size(); i++) {
            Medal before = list.get(i - 1);
            int beforeGold = before.gold;
            int beforeSilver = before.silver;
            int beforeBronze = before.bronze;

            Medal current = list.get(i);

            // 인덱스 저장해두기
            if (list.get(i).country == k) {
                temp = i;
            }

            // 등수가 다 동일하면 랭크도 동일
            if (beforeGold == current.gold && beforeSilver == current.silver
                    && beforeBronze == current.bronze) {
                current.rank = before.rank;
                continue;
            }
            current.rank = i+1;
        }

        buf2.write(list.get(temp).rank + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static class Medal {
        int country;
        int gold;
        int silver;
        int bronze;

        int rank;

        public Medal(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}