package Level1;

import java.util.ArrayList;
import java.util.Collections;

public class MockTest {
    // 1번 수포자 : 1->2->3->4->5 반복
    // 2번 수포자 : 2->1->2->3->2->4->2->5
    // 3번 수포자 : 3->3->1->1->2->2->4->4->5->5

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] one_answer = {1, 2, 3, 4, 5};
        int[] two_answer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three_answer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int one_count = 0;
        int two_count = 0;
        int three_count = 0;


        for(int i=0; i<answers.length; i++) {
            if (answers[i] == one_answer[i%5])
                one_count++;

            if (answers[i] == two_answer[i%8])
                two_count++;

            if (answers[i] == three_answer[i%10])
                three_count++;
        }


        // int형 arrayList 만들 때 Integer로 쓰기...
        ArrayList<Integer> number = new ArrayList<>();

        number.add(one_count);
        number.add(two_count);
        number.add(three_count);

        int max_num = Collections.max(number);

        int idx = 0;

        // ArrayList 크기 -> .size()
        // 원소 가져올 때 .get(index)
        for(int i=0; i< number.size(); i++) {
            if (max_num == number.get(i)) {
                idx++;
            }
        }

        // 자바는 꼭 new형으로 공간 할당을 해줘야 한다는 점 잊지 말기...!
        answer = new int[idx];
        idx = 0;

        for(int i=0; i< number.size(); i++) {
            if (max_num == number.get(i)) {
                answer[idx] = i+1;
                idx++;
            }
        }

        return answer;
    }
}
