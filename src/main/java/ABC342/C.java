package src.main.java.ABC342;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String s = scanner.next();
        int Q = scanner.nextInt();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }else {
                map.get(c).add(i);
            }
        }
        for (int i = 0; i < Q; i++) {
            char c = scanner.next().charAt(0);
            char d = scanner.next().charAt(0);
            // c==dの場合は何もしない
            if (c == d) {
                continue;
            }
            // cが存在しない場合は何もしない
            if(!map.containsKey(c)) {
                continue;
            }
            ArrayList<Integer> list = map.get(c);
            map.remove(c);
            if (!map.containsKey(d)) {
                map.put(d, list);
                continue;
            }

            map.get(d).addAll(list);
        }
        char[] ans = new char[N];
        for (char c : map.keySet()) {
            ArrayList<Integer> list = map.get(c);
            if(list == null) {
                continue;
            }
            for (int i : list) {
                ans[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]);
        }
        System.out.println(sb.toString());
    }
}