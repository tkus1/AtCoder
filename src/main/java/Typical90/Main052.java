package src.main.java.Typical90;

import java.util.Scanner;

public class Main052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] A = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        long[] sum = new long[N];
        for (int i = 0; i < N; i++) {
            sum[i] = 0;
            for (int j = 0; j < 6; j++) {
                sum[i] += A[i][j];
            }
        }
        long ans = 1;
        final long MOD = 1000000007;
        for (int i = 0; i < N; i++) {
            ans *= sum[i];
            ans %= MOD;
        }
        System.out.println(ans);

    }
}
