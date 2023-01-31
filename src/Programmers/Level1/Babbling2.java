package Programmers.Level1;

// 옹알이 (2)
class Babbling2 {
    private static final String[] WORDS = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        for (String bab : babbling) {
            for (int i=0; i<WORDS.length; i++) {
                bab = bab.replaceAll(WORDS[i], String.valueOf(i));
            }

            Character prev = null;
            boolean isSuccess = true;

            for (int i=0; i<bab.length(); i++) {
                if ((prev != null && prev == bab.charAt(i)) || (Character.isAlphabetic(bab.charAt(i)))) {
                    isSuccess = false;
                    break;
                }
                prev = bab.charAt(i);
            }

            if (isSuccess) {
                answer++;
            }
        }
        return answer;
    }
}