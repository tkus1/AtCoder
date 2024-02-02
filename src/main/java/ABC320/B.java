package src.main.java.ABC320;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int maxLength = 1;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                StringBuilder subStr = new StringBuilder(s.substring(i, j+1));
                if (isPalindrome(subStr.toString())) {
                    maxLength = Math.max(maxLength, subStr.length());
                }
            }
        }
        System.out.println(maxLength);

    }
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
