package src.main.java.ABC342;

import java.util.HashMap;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int prevVal = map.getOrDefault(c, 0);
            map.put(c, prevVal + 1);
        }
        char target = 0;
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                target = c;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == target) System.out.println(i+1);
        }
    }
}