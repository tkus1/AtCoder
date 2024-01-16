package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main069 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        int K = scanner.nextInt();
        final long MOD = 1000000007;
        if(N == 1){
            System.out.println(K);
            return;
        }
        if(N == 2){
            System.out.println(K * (K-1));
            return;
        }
        if (K == 1) {
            System.out.println(0);
            return;
        }
        if(K == 2){
            System.out.println(0);
            return;
        }
        long ans = (long) K * (K-1) % MOD;
        List <Integer> digits = getDigits(N-2);
        int digitLength = digits.size();
        long[] multiplier = new long[digitLength];
        multiplier[0] = K-2;
        for (int i = 1; i < digitLength; i++) {
            multiplier[i] = 1;
            for (int j = 0; j < 10; j++) {
                multiplier[i] *= multiplier[i-1];
                multiplier[i] %= MOD;
            }
        }
        for (int i = 0; i < digitLength; i++) {
            int times = digits.get(i);
            for (int j = 0; j < times; j++) {
                ans *= multiplier[i];
                ans %= MOD;
            }
        }

        System.out.println(ans);
    }
    public static List<Integer> getDigits(long num){
        List<Integer> digits = new ArrayList<>();
        while(num > 0){
            digits.add((int) (num % 10));
            num /= 10;
        }
        return digits;
    }
}
