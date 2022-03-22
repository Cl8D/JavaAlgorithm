package Programmers.Level1;

import java.util.Locale;

public class NewIdRecommend {
    public static String main(String[] args) {
        String new_id =""; // 원래 input

        // id length 3~15
        // 알파벳 소문자, 숫자, -, _, .(처음, 끝 x)

        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase(Locale.ROOT);

        // 2. 소문자,숫자,-,_,. 빼고 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. .. 2번 -> . 1번
        new_id = new_id.replaceAll("[.]{2,}", ".");

        // 4. .가 처음이나 끝이라면 제거
        int len = new_id.length();


        if(len>0 && new_id.charAt(0) == '.')
            new_id = new_id.substring(1, len);

        len = new_id.length();

        if(len>0 && new_id.charAt(len-1) == '.')
            new_id = new_id.substring(0, len-1);


        // 5. 빈 문자열이라면 a 대입
        if (new_id.length() == 0)
            new_id = "a";


        // 6. length >= 16 -> 15개 빼고 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            // 이때, .가 끝에 온다면 제거
            if(new_id.charAt(14) == '.')
                new_id = new_id.substring(0, 14);
        }


        // 7. length <=2 -> 3이상이 되도록 마지막 문자 붙이기
        if(new_id.length() <= 2) {
            while(true) {
                len = new_id.length();
                if (len >= 3)
                    break;

                new_id = new_id + new_id.charAt(len-1);

            }
        }



        return new_id;
    }
}
