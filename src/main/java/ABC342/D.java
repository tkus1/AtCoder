package src.main.java.ABC342;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        long zeroCount = 0;
        for (int i = 0; i < N; i++) {
            long A = scanner.nextLong();
            if(A == 0){
                zeroCount++;
                continue;
            }
            ArrayList<Long> residualFactors = Calculator.removeDuplicateFactors(Calculator.primeFactorization(A));
            long value = 1;
            for (Long residualFactor : residualFactors) {
                value *= residualFactor;
            }
            map.put(value, map.getOrDefault(value, 0L) + 1);
        }
        long ans = 0;
        for(long i : map.keySet()){
            if (map.get(i) > 1) {
                ans += Calculator.nCr(map.get(i), 2);
            }
        }
        ans += zeroCount * (N - zeroCount) + Calculator.nCr(zeroCount, 2);
        System.out.println(ans);

    }

    public static class Calculator {
        public static ArrayList<Long> primeFactorization(long n) {
            ArrayList<Long> factors = new ArrayList<>();
            for (long i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    factors.add(i);
                    n /= i;
                }
            }
            if (n > 1) {
                factors.add(n);
            }
            return factors;
        }

        public static ArrayList<Long> removeDuplicateFactors(ArrayList<Long> factors) {
            Collections.sort(factors);
            ArrayList<Long> result = new ArrayList<>();
            for (int i = 0; i < factors.size(); i++) {
                if (i + 1 < factors.size() && factors.get(i).equals(factors.get(i + 1))) {
                    i++;
                } else {
                    result.add(factors.get(i));
                }
            }
            return result;
        }
        public static long nCr(long n, long r) {
            if (r > n) {
                return 0;
            }
            if (r * 2 > n) {
                r = n - r;
            }
            if (r == 0) {
                return 1;
            }
            long result = n;
            for (long i = 2; i <= r; i++) {
                result *= (n - i + 1);
                result /= i;
            }
            return result;
        }
    }

}