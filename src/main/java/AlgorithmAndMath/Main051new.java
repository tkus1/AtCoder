package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main051new {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        // DPテーブルの初期化
        int[] dp = new int[X + 1];
        dp[0] = 1;

        // 組み合わせ数を計算する
        for (int i = 1; i <= X + Y; i++) {
            for (int j = Math.min(i, X); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        System.out.println(dp[X]);
    }
}
