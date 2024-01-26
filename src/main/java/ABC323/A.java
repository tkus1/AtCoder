package src.main.java.ABC323;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 1; i < s.length(); i+=2) {
            if(s.charAt(i) != '0') {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
