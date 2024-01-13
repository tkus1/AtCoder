package src.main.java.Typical90;

import java.util.Scanner;

public class Main042 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        if(K % 9 != 0){
            System.out.println(0);
            return;
        }
        final int MOD = 1000000007;
        long[] dp = new long[K+1];
        dp[0] = 1;
        for (int i = 1; i <= K; i++) {
            int B = Math.min(9, i);
            for (int j = 1; j <= B; j++) {
                dp[i] += dp[i - j];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[K]);
    }
}
