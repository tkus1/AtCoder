package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC081A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        int length = a.length();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if(a.charAt(i)=='1'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
