package src.main.java.Typical90;

import java.util.Scanner;

public class Main022_Cubic_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long gcdAB = Helper.gcd(A, B);
        long gcdABC = Helper.gcd(gcdAB, C);
        long ans = (A / gcdABC - 1) + (B / gcdABC - 1) + (C / gcdABC - 1);
        System.out.println(ans);
    }
    public static class Helper{
        public static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a%b);
        }
    }
}
