package src.main.java.ABC327;

import java.util.Scanner;

public class A {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[] S = scanner.next().toCharArray();

        for (int i = 0; i < N-1; i++) {
            if((S[i] == 'a' && S[i+1] == 'b') || (S[i] == 'b' && S[i+1] == 'a')){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
