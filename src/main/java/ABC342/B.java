package src.main.java.ABC342;

import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            for (int j = 0; j < N; j++) {
                if(P[j] == A) {
                    System.out.println(A);
                    break;
                }
                if(P[j] == B) {
                    System.out.println(B);
                    break;
                }
            }
        }
    }
}