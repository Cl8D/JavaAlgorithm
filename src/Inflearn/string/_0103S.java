package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 문장 속 단어 - 솔루션 코드
public class _0103S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();

        String result = "";

        // 이런 식으로 가장 작은 값을 넣을 수 있다는 점!
        int maxLength = Integer.MIN_VALUE;

        int pos;

        // 공백을 처음으로 만난 위치의 인덱스 값 반환
        // It is time to study라고 한다면,
        // 현재 pos에는 첫 공백의 인덱스 2가 들어간다.
        while((pos=str.indexOf(' ')) != -1) {
            // 0~pos-1까지 잘라내기 -> "it"
            String tmp = str.substring(0, pos);
            int length = tmp.length();

            if (length > maxLength) {
                maxLength = length;
                result = tmp;
            }

            // 다음 문자열 탐색하기
            // 공백 그 다음 위치부터 재탐색.
            // 즉, 3의 위치인 i부터 다시 탐색하게 된다.
            str = str.substring(pos+1);
        }

        // 마지막 단어는 while문 조건에 의해서 탐색을 못하게 되니까
        // (왜냐면, study 이후에는 공백이 없어서 -1이 리턴되고 종료됨)
        // 마지막 단어에 대한 처리도 해줘야 한다.
        if(str.length() > maxLength)
            result = str;

        System.out.println(result);

    }
}
