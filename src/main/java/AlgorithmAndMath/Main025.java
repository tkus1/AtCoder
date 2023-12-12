package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main025 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double expectation = 0;
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }
        final double P_A = (double) 2 / 6;
        for (int i = 0; i < N; i++) {
            expectation += P_A * A[i] + (1 - P_A) * B[i] ;
        }
        System.out.println(expectation);
    }



}
