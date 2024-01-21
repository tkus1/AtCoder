package src.main.java.library;

import java.math.BigInteger;

public class ExtGCD {
    public static long[] extGcd(long a, long b) {
        if(b == 0) {
            return new long[]{a, 1, 0};
        }
        long[] dxy = extGcd(b, a%b);
        long d = dxy[0];
        long x = dxy[2];
        long y = dxy[1] - (a/b) * dxy[2];
        return new long[]{d, x, y};

    }
    public static void main (String[] args) {
        long[] dxy = extGcd(111, 30);
        //System.out.println(dxy[0] + " " + dxy[1] + " " + dxy[2]);
        final long MOD = 998244353;
        dxy = extGcd(100000, MOD);
        System.out.println(dxy[0] + " " + dxy[1] + " " + dxy[2]);
        long inverseB = dxy[1]/dxy[0];
        System.out.println(inverseB);
        long a = 12345678900000L;
        BigInteger ans = ((BigInteger.valueOf(inverseB).multiply(BigInteger.valueOf(a))).mod(BigInteger.valueOf(MOD)));
        System.out.println(ans);
        System.out.println((inverseB * (a % MOD)) % MOD);
    }
}
