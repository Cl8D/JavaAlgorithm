package leetcode.medium;

import java.util.*;

// Largest Number
class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        list.sort((o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        StringBuilder result = new StringBuilder();

        for (String ans : list) {
            result.append(ans);
        }

        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
