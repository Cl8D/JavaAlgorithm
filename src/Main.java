
import java.io.*;
import java.util.*;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        int k = Integer.parseInt(buf.readLine());
        PriorityQueue<Type> pq = new PriorityQueue<>((o1, o2) -> {
          if (o1.count == o2.count) {
            return o2.time - o1.time;
          }
          return o1.count - o2.count;
        });
        int time = 0;
        for(int i=0; i<k; i++) {
           int student = Integer.parseInt(buf.readLine());
           Type type = new Type(student, 0, 0);
           if (!pq.contains(type)) {
             pq.add(new Type(student, 1, time++));
             continue;
           }
          
        }
        }
        static class Type {
          int number;
          int count;
          int time;
          
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

        }
}
