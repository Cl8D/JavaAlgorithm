package Programmers.Level2;

import java.util.*;

// 이모티콘 할인 행사
class EmoticonDiscount {
    private static final int[] DISCOUNT_RATE = {10, 20, 30, 40};
    private static int[][] users;
    private static int[] emoticons;
    private static List<Result> results = new ArrayList<>();

    public int[] solution(int[][] tempUser, int[] tempEmoticon) {
        int[] answer = new int[2];
        users = tempUser;
        emoticons = tempEmoticon;


        // 1. 이모티콘 플러스 서비스 가입자 늘리기 (<< 이게 1차 조건.)
        // 2. 이모티콘 판매액 늘리기

        // 일정 비율 이상 할인하는 이모티콘 모두 구매
        // 이모티콘 구매 비용의 합이 일정 가격 이상 -> 이모티콘 구매 취소, 이모티콘 플러스 가입.

        int[] discounts = new int[emoticons.length];
        combi(0, emoticons.length, discounts);

        int maxRegister = 0;
        int maxSales = 0;

        for (Result result : results) {
            int registerNum = result.registerNum;
            int sales = result.sales;

            if (result.registerNum > maxRegister) {
                maxRegister = registerNum;
                maxSales = sales;
            }

            if (result.registerNum == maxRegister) {
                maxSales = Math.max(maxSales, sales);
            }
        }

        answer[0] = maxRegister;
        answer[1] = maxSales;

        return answer;
    }

    // 각 이모티콘에 대한 할인율을 배정한다.
    private void combi(int level, int m, int[] discounts) {
        if (level == m) {
            checkDiscount(discounts);
            return;
        }

        for (int discount : DISCOUNT_RATE) {
            discounts[level] = discount;
            combi(level + 1, m, discounts);
        }
    }

    private void checkDiscount(int[] discounts) {
        // 이모티콘 플러스 가입자 수
        int registerNum = 0;
        // 이모티콘 판매액 
        int sales = 0;

        for (int[] user : users) {
            // 원하는 할인 비율
            int rate = user[0];
            // 이모티콘 구매 비용
            int price = user[1];

            // 현재 사용자의 구매 비용
            int cost = 0;

            // 각각의 이모티콘에 대한 할인율을 비교한다.
            for (int i=0; i<discounts.length; i++) {
                int discount = discounts[i];
                // 만약 이모티콘 할인율이 더 높으면 구매를 진행한다.
                if (rate <= discount) {
                    cost += getDiscountPrice(discount, emoticons[i]);
                }
            }

            // 판매액을 증가시킨다.
            sales += cost;

            // 사용자의 구매 비용이 가격보다 커지면, 플러스에 가입한다.
            if (cost >= price) {
                registerNum++;
                // 구매를 취소한다.
                sales -= cost;
            }
        }

        // 최종 결과에 대해서 담아둔다.
        results.add(new Result(registerNum, sales));
    }

    private int getDiscountPrice(int discountRate, int price) {
        double rate = 0.01 * (100 - discountRate);
        return (int) (price * rate);
    }

    static class Result {
        int registerNum;
        int sales;

        public Result(int registerNum, int sales) {
            this.registerNum = registerNum;
            this.sales = sales;
        }
    }
}