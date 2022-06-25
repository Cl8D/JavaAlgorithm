package BOJ.Silver.Silver1;

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stk;
//
//        // 처음에 짠 코드. 시간 초과 때문에 50점밖에 못 받았다.
//        int n = Integer.parseInt(buf.readLine());
//        int m = Integer.parseInt(buf.readLine());
//        String s = buf.readLine();
//
//
//        StringBuilder p = new StringBuilder("I");
//
//        for(int i=0; i<n; i++)
//            p.append("OI");
//
//        StringBuilder temp = new StringBuilder();
//        int answer = 0;
//
//        for(int i=0; i<m; i++) {
//            if(temp.length() == p.length()) {
//                if(temp.toString().equals(p.toString())) {
//                    answer++;
//                    temp = new StringBuilder(temp.substring(1));
//                }
//                temp = new StringBuilder(temp.substring(1));
//            }
//            temp.append(s.charAt(i));
//        }
//
//        buf2.write(String.valueOf(answer));
//        buf2.flush();
//        buf.close();
//        buf2.close();
//    }
//}


import java.io.*;
import java.util.*;

// IOIOI
public class _5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int m = Integer.parseInt(buf.readLine());
        char[] s = buf.readLine().toCharArray();

        // 시간 문제를 해결하기 위해서, KMP - 문자열 검색 알고리즘 활용
        // https://injae-kim.github.io/dev/2020/07/23/all-about-kmp-algorithm.html
        // 일부를 건너 뛰어서 탐색, 건너뛴 다음 탐색 문자열의 앞 부분과 원본 문자열의 뒷부분이 동일해야 함.
        // 정확한 개념은 나동빈님 유튜브 참고...!

        // 근데 뭔가 너무 복잡해서 그냥 다른 분 알고리즘 참고함
        // https://mizzo-dev.tistory.com/entry/baekjoon5525

        int answer = 0;
        int patternCount = 0; // 'IOI' 패턴의 연속 횟수
        for(int i=1; i<m-1; i++) {
            if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
                patternCount++;
                // 패턴의 연속 횟수 = Pn을 만들어내는 조건
                // p1 = IOI, p2=IOIOI라고 했을 때, IOIOI는 (IOI)OI, IO(IOI) 이렇게 IOI가 2번 반복된다고 볼 수 있음!
                if (patternCount == n) {
                    patternCount--; // pn이 연속해서 나타날 수 있기 때문에 -1을 해준다
                    answer++;
                }
                i++; // 그리고 2칸 뒤로 이동 (for문에 의해서 1칸, 여기서 1칸 => 기준값이 O니까 다음 기준으로 이동한다고 생각
            }
            else
                patternCount = 0;  // 아니라면 패턴 연속 횟수 초기화
        }

        buf2.write(String.valueOf(answer));
        buf2.flush();
        buf.close();
        buf2.close();
    }



}