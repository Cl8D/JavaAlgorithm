package Programmers.Level2;

// N개의 최소공배수
class NGcm {
    public int solution(int[] arr) {
        if (arr.length==1) {
            return arr[0];
        }

        int answer = lcm(arr[0], arr[1]);
        for (int i=2; i< arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    private int lcm (int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}