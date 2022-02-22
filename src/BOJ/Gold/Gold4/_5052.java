package BOJ.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _5052 {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(buf.readLine());

            int answer = 0;

            Map<String, Integer> phone = new HashMap<String, Integer>();
            List<String> phone_book = new ArrayList<>();

            for(int j = 0; j<n; j++) {
                String str = buf.readLine();
                phone.put(str, j);
                phone_book.add(str);
            }


            for(int j =0; j<n; j++) {
                for(int k=0; k<phone_book.get(j).length(); k++) {
                    if(phone.containsKey(phone_book.get(j).substring(0, k))) {
                        answer = 1;
                    }
                }
            }



            if (answer == 0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
