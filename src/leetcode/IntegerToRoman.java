package leetcode;

// IntegerToRoman
class IntegerToRoman {
    private static final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] NUMBER = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < NUMBER.length; i++) {
            int n = NUMBER[i];
            while (num >= n) {
                num -= n;
                answer.append(ROMAN[i]);
            }
        }
        return answer.toString();
    }
}
