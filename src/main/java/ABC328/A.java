package src.main.java.ABC328;

import java.util.Scanner;

public class A {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            if(A <= X){
                sum += A;
            }

        }
        System.out.println(sum);
    }
}
