package Programmers.Level2;

import java.util.*;

// 수식 최대화
class FormulaMaximization {
    // 수식은 - + * 3가지로 제한이 되어 있기 때문에 6가지의 모든 경우에 대해서 탐색.
    private static final String[][] operations = {
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "-", "+"},
            {"*", "+", "-"},
            {"+", "-", "*"},
            {"+", "*", "-"}
    };

    public long solution(String expression) {
        long answer = 0;

        // 3가지의 연산 문자 = +, -, *
        // 우선순위는 무조건 동일하지 않도록 설정
        // 계산된 결과가 음수라면 절댓값으로 변환하여 제출.
        // 제줄한 숫자가 가장 큰 참가자가 우승자. -> 우선순위를 잘 고려해서 가장 높게 나오도록.

        // expression -> 중위표기법으로 표현된 연산식.
        // answer -> 가장 큰 상금 금액.

        // 순수 번호만 추출.
        String[] nums = expression.split("[\\+\\|\\-\\|*]");
        // 연산자만 추출.
        String[] opers = expression.split("[0-9]+");

        // 번호 + 연산자로 이루어진 리스트를 생성한다.
        List<String> exprs = createExprs(nums, opers);

        // 각각의 경우에 대해서 탐색 진행.
        for(String[] operator : operations) {
            // 각 경우에 대해 원본 리스트를 계속 복원해온다.
            List<String> temp = new ArrayList<>(exprs);

            // 주어진 수식 대해서 해당 연산자가 포함되어 있다면
            for (String oper : operator) {
                while (temp.contains(oper)) {
                    // 해당 연산자의 인덱스 확인
                    int index = temp.indexOf(oper);
                    // 연산자 앞 뒤의 문자 가져오기
                    String numberA = temp.get(index-1);
                    String numberB = temp.get(index+1);
                    // 계산한 결과 가져오기.
                    long result = calculate(numberA, numberB, oper);

                    // 연산자가 있는 위치에 계산 결과 바꿔치기하기
                    temp.set(index, String.valueOf(result));
                    // 이전에 존재하던 앞뒤의 문자는 제거해두기
                    temp.remove(index+1);
                    temp.remove(index-1);
                }
            }
            // 가장 큰 값을 정답으로 처리한다.
            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }

        return answer;
    }

    private static List<String> createExprs(String[] nums, String[] opers) {
        List<String> exprs = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                exprs.add(nums[i]);
                continue;
            }
            exprs.add(opers[i]);
            exprs.add(nums[i]);
        }
        return exprs;
    }

    private static long calculate(String a, String b, String oper) {
        long numA = Long.parseLong(a);
        long numB = Long.parseLong(b);
        if (oper.equals("-")) {
            return numA - numB;
        }
        if (oper.equals("+")) {
            return numA + numB;
        }
        return numA * numB;
    }
}