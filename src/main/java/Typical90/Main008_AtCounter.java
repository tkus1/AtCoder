package src.main.java.Typical90;

import java.util.Scanner;

public class Main008_AtCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        final String TARGET_STRING = "atcoder";
        String S = scanner.next();
        final int MOD_NUM = 1000000007;
        int M = TARGET_STRING.length();
        long[][] dp = new long[N+1][M+1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= M; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1) == TARGET_STRING.charAt(j-1)){
                    dp[i][j] = Math.floorMod(dp[i][j] + dp[i-1][j-1], MOD_NUM);
                }
            }
        }
        System.out.println(dp[N][M]);

    }
}
