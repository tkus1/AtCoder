package src.main.java.Typical90;

import java.math.BigInteger;
import java.util.Scanner;

public class Main038 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long gcd = Helper.gcd(A, B);
        BigInteger ans = (BigInteger.valueOf(A).divide(BigInteger.valueOf(gcd))).multiply(BigInteger.valueOf(B));
        if(ans.compareTo(BigInteger.valueOf(1000000000000000000L)) > 0){
            System.out.println("Large");
            return;
        }
        System.out.println(ans);
    }
    public static class Helper{
        public static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a%b);
        }
    }
}
