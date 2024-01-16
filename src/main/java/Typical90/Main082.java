package src.main.java.Typical90;

import java.util.Scanner;

public class Main082 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long L = scanner.nextLong();
        long R = scanner.nextLong();
        long cntL = calcNumOfString(L-1);
        long cntR = calcNumOfString(R);
        final long MOD = 1000000007;
        long ans = (cntR - cntL)%MOD;
        if (ans < 0){
            ans += MOD;
        }
        System.out.println(ans);
    }
    public static long calcSumToN(long N){
        N %= 1000000007;
        return (N * (N + 1) / 2) % 1000000007;
    }
    public static long calcSumFromAToB(long A, long B){
        return calcSumToN(B) - calcSumToN(A-1);
    }
    public static long calcNumOfString(long N){
        int digit = getDigit(N);
        if(digit == 1 ){
            return calcSumToN(N);
        }
        int multiplier = 1;
        long startNum = 1;
        long endNum = 9;
        long sum = 0;
        for (int i = 1; i < digit; i++) {
            sum += (calcSumFromAToB(startNum, endNum) * multiplier) % 1000000007;
            multiplier++;
            startNum *= 10;
            endNum = endNum * 10 + 9;
        }
        sum += calcSumFromAToB(startNum, N) * multiplier;
        return sum;
    }
    public static int getDigit(long num){
        return String.valueOf(num).length();
    }
}
