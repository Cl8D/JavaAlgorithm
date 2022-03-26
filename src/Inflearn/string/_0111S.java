package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 11. 문자열 압축 - 솔루션 코드
public class _0111S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        // 인덱스를 넘겨가면서 다음 문자와 동일한지 확인, count 증가

        String answer= "";

        // 가장 마지막 문자는 그 다음에 아무것도 없어서 인덱스 에러가 날 수 있기 때문에
        // 그냥 빈 문자 하나 넣어주기
        str = str + " ";
        int count = 0;

        // 빈문자를 추가했었으니까 그 전까지만 탐색하도록
        for(int i=0; i<str.length()-1; i++) {
            // 같은 문자면 count만 증가
            if(str.charAt(i) == str.charAt(i+1))
                count++;
            else {
                // 다르다면 결과에 추가해주는 작업
                answer += str.charAt(i);
                if (count > 1)
                    answer += String.valueOf(count);
                count = 1;
            }
        }

        System.out.println(answer);

    }
}
