package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 결혼식
public class _5567 {
    static Map<Integer, List<Integer>> friendMap;
    static Set<Integer> inviteSet;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        int m = Integer.parseInt(buf.readLine());

        friendMap = new HashMap<>();
        inviteSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            List<Integer> aFriendMap = friendMap.getOrDefault(a, new ArrayList<>());
            aFriendMap.add(b);
            friendMap.put(a, aFriendMap);

            List<Integer> bFriendMap = friendMap.getOrDefault(b, new ArrayList<>());
            bFriendMap.add(a);
            friendMap.put(b, bFriendMap);
        }

        // 처음에 자기 자신 넣어두고 나중에 제거
        inviteSet.add(1);
        searchFriend();

        buf2.write(inviteSet.size()-1 + "");

        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void searchFriend() {
        List<Integer> friendList = friendMap.get(1);
        if (friendList != null) {
            inviteSet.addAll(friendList);

            for (Integer diffUser : friendList) {
                if (friendMap.get(diffUser) != null) {
                    inviteSet.addAll(friendMap.get(diffUser));
                }
            }
        }
    }
}