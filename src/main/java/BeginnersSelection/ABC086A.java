package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC086A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String ans = "Odd";
        if(a % 2 == 0 || b % 2 == 0){
            ans = "Even";
        }
        System.out.println(ans);
    }

}
