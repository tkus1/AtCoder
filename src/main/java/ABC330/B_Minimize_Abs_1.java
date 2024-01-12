package src.main.java.ABC330;

import java.util.Scanner;

public class B_Minimize_Abs_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            if (L == R) {
                ansStr.append(" ").append(L);
                continue;
            }
            if (A < L) {
                ansStr.append(" ").append(L);
                continue;
            }
            if (A > R) {
                ansStr.append(" ").append(R);
                continue;
            }
            ansStr.append(" ").append(A);
        }
        ansStr.deleteCharAt(0);
        System.out.println(ansStr);
    }
}
