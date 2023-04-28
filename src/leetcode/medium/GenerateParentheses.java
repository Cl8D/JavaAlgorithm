package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Generate Parentheses
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        dfs(answer, new StringBuilder("("), n - 1, n);
        return answer;
    }

    private void dfs(final List<String> answer, StringBuilder str, int left, int right) {
        // 다 만들었으면 정답에 추가해주기
        if (left == 0 && right == 0) {
            answer.add(str.toString());
            return;
        }

        if (left > 0) {
            dfs(answer, str.append("("), left-1, right);
            str.deleteCharAt(str.length()-1);
        }

        // 균형 잡힌 괄호를 만들어야 하기 때문에
        // 오른쪽 괄호의 남은 개수가 왼쪽 괄호의 남은 개수가 더 클 때 오른쪽 괄호를 붙일 수 있다.
        // 오른쪽 괄호가 더 많으면 균형잡혔다고 말할 수가 없다.
        if (left < right) {
            dfs(answer, str.append(")"), left, right - 1);
            str.deleteCharAt(str.length()-1);
        }
    }
}
