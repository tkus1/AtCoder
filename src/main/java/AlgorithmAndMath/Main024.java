package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main024 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long p;
        long q;
        double expectation = 0;
        for (int i = 0; i < N; i++) {
            p = scanner.nextInt();
            q = scanner.nextInt();
            expectation += (q/p);
        }

        System.out.println(expectation);

    }
}
