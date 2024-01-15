package src.main.java.Typical90;
import java.util.Scanner;
public class Main050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        long[] dp = new long[N+1];
        dp[0] = 1;
        final long MOD = 1000000007;
        for (int i = 1; i <= N; i++) {
            dp[i] += dp[i-1] % MOD;
            if(i >= L) {
                dp[i] += dp[i - L] % MOD;
            }
        }
        System.out.println(dp[N] % MOD);
    }
}
