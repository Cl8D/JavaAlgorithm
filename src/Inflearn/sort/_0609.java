package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9. 뮤직비디오 - 솔루션 코드 보면서 풀었음.
public class _0609 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] dvd = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            dvd[i] = Integer.parseInt(stk.nextToken());

        // 결정 알고리즘
        // lt~rt 사이의 문제에서 요구하는 답이 분명하게 있다고 생각할 때 사용.
        // 그리고 이분 검색을 했을 때 나오는 값이 답으로써 가능한지 판단

        // 1 2 3 4 5 6 7 8 9
        // dvd 한 장의 용량 중에 가장 작은 경우의 수 -> 9
        // 반대로 가장 큰 경우의 수 -> 한 장에 전부 다 들어가는 경우 -> 45
        // 그리고 mid = 27일 텐데, 이러면 (1 2 3 4 5 6) (7 8 9) 이래서 2장으로 된다.
        // 2장이 되면 3장으로 나눈 건 당연히 되기 때문에 (1 2 3 4 5) (6 7) (8 9) 27은 정답 후보가 된다.
        // 최소 용량이니까 rt=mid-1=26으로 해서 다시 재탐색 (lt=9, rt=26, mid=17)


        // dvd 배열에서 가장 큰 수
        int lt = Arrays.stream(dvd).max().getAsInt();
        // dvd 배열에서 전체 합한 값
        int rt = Arrays.stream(dvd).sum();

        int answer = 0;

        while(lt<=rt) {
            int mid = (lt+rt)/ 2;
            // 리턴된 dvd 장수가 m보다 작으면 됨 (2장이어도 3장으로 나눌 수 있으니깐)
            if(count(dvd, mid) <= m) {
                answer = mid;
                // 우선 답을 저장해놓고 더 줄여나가며 이분탐색
                rt = mid-1;
            }
            // 만약 안 담아진다면 더 큰쪽을 탐색해야 함
            else {
                lt = mid+1;
            }
        }

        System.out.println(answer);

    }

    // capacity -> dvd 한 장의 용량
    static int count(int[] dvd, int capacity) {
        // dvd의 장수, 초기값은 1.
        int cnt = 1;
        // dvd에 담아내는 곡들의 합
        int sum = 0;

        for(int x : dvd) {
            // 곡을 담았을 때 용량을 초과하게 된다면
            if(sum+x > capacity) {
                // dvd의 장수 증가
                cnt++;
                // sum에 새로운 곡을 넣어준다.
                // 즉, 이는 <현재 사용되고 있는> dvd에 얼마나 저장되고 있는지를 판단함
                sum = x;
            }
            else
                sum += x;
        }

        return cnt;
    }
}
