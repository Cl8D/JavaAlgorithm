package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;
import java.util.PriorityQueue;

// 후보 추천하기
public class _1713 {
    private static final PriorityQueue<Type> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.count == o2.count) {
            return o1.time - o2.time;
        }
        return o1.count - o2.count;
    });
    private static final Map<Integer, Type> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        int k = Integer.parseInt(buf.readLine());

        stk = new StringTokenizer(buf.readLine());
        for (int time = 0; time < k; time++) {
            int student = Integer.parseInt(stk.nextToken());
            if (pq.size() < n) {
                if (pq.contains(new Type(student))) {
                    updateStudentInfo(student);
                } else {
                    addStudentInfo(time, student);
                }
            } else {
                if (pq.contains(new Type(student))) {
                    updateStudentInfo(student);
                } else {
                    pq.poll();
                    map.put(student, new Type(student, 0, 0));
                    addStudentInfo(time, student);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll().number);
        }
        answer.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(number -> sb.append(number).append(" "));
        System.out.println(sb);
    }

    private static void addStudentInfo(final int time, final int student) {
        Type current = map.getOrDefault(student, new Type(student, 0, time));
        map.put(student, new Type(student, current.count + 1, time));
        pq.add(new Type(student, map.get(student).count, time));
    }

    private static void updateStudentInfo(final int student) {
        pq.remove(new Type(student));
        addStudentInfo(map.get(student).time, student);
    }

    static class Type {
        int number;
        int count;
        int time;

        public Type(final int number) {
            this.number = number;
        }

        public Type(int number, int count, int time) {
            this.number = number;
            this.count = count;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Type type = (Type) o;
            return Objects.equals(number, type.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "Type{" +
                    "number=" + number +
                    ", count=" + count +
                    ", time=" + time +
                    '}';
        }
    }
}

