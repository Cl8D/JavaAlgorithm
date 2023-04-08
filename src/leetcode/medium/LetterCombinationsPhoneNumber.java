package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Letter Combinations of a Phone Number
public class LetterCombinationsPhoneNumber {
    private static final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return Collections.emptyList();
        }
        List<String> answer = new ArrayList<>();
        combi(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void combi(String digits, int depth, StringBuilder str, List<String> answer) {
        if (depth == digits.length()) {
            answer.add(str.toString());
            return;
        }
        int idx = Character.getNumericValue(digits.charAt(depth));
        char[] current = letters[idx].toCharArray();

        for (char ch : current) {
            str.append(ch);
            combi(digits, depth + 1, str, answer);
            str.delete(depth, depth + 1);
        }
    }
}
