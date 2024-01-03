package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MOD_NUM = 1000000007;
        long X = scanner.nextInt() + 1;
        long Y = scanner.nextInt() + 1;
        long[] dp = new long[(int)X];
        for (int i = 0; i < X; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < Y; i++) {
            for (int j = 1; j < X; j++) {
                dp[j] += dp[j-1];
                if(dp[j] > MOD_NUM){
                    dp[j] -= MOD_NUM;
                }
            }
        }

        long ans = dp[(int)X-1];
        System.out.println(ans);
    }


}
