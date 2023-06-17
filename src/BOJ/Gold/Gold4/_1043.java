package BOJ.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 거짓말
public class _1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 사람의 수
        int n = Integer.parseInt(stk.nextToken());

        // 파티의 수
        int m = Integer.parseInt(stk.nextToken());

        // 이야기의 진실을 아는 사람의 수
        stk = new StringTokenizer(buf.readLine());
        int know = Integer.parseInt(stk.nextToken());

        if (know == 0) {
            System.out.println(m);
            return;
        }

        // 진실을 아는 사람들을 기준으로 탐색 진행
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < know; i++) {
            queue.add(Integer.parseInt(stk.nextToken()));
        }

        // 파티별 사람들의 인원 저장
        List<Integer>[] personByParty = new ArrayList[m];

        // 참가자들의 파티 정보 저장
        List<Integer>[] partyByPerson = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            partyByPerson[i] = new ArrayList<>();
        }

        // 파티마다 오는 사람의 수
        for (int party = 0; party < m; party++) {
            personByParty[party] = new ArrayList<>();

            stk = new StringTokenizer(buf.readLine());
            int count = Integer.parseInt(stk.nextToken());

            for (int j = 0; j < count; j++) {
                // 파티에 참가한 참가자 정보 저장
                int attendee = Integer.parseInt(stk.nextToken());
                personByParty[party].add(attendee);

                // 참가자의 파티 정보 저장
                partyByPerson[attendee].add(party);
            }
        }

        // 진실을 말해야 하는 파티인지 저장
        boolean[] isTruthParty = new boolean[m];

        // 참가자별로 순회 정보 저장
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int truthPerson = queue.poll();
            visited[truthPerson] = true;

            // 진실을 아는 참가자의 파티 정보 가져오기
            for (int party : partyByPerson[truthPerson]) {
                // 해당 파티의 경우 무조건 진실을 말해야 하는 파티임
                isTruthParty[party] = true;

                // 해당 파티에 참가한 참가자들에 대해서 또 다시 탐색하기
                for (int person : personByParty[party]) {
                    if (!visited[person]) {
                        queue.add(person);
                    }
                }
            }
        }

        int answer = 0;
        for (boolean isTruth : isTruthParty) {
            if (!isTruth) {
                answer++;
            }
        }

        System.out.println(answer);
        buf.close();
    }
}
