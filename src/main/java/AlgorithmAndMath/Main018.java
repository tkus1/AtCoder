package src.main.java.AlgorithmAndMath;

import java.math.BigInteger;
import java.util.Scanner;

public class Main018 {

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt100 = 0;
        int cnt200 = 0;
        int cnt300 = 0;
        int cnt400 = 0;
        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            switch (input){
                case 100:
                    cnt100++;
                    break;
                case 200:
                    cnt200++;
                    break;
                case 300:
                    cnt300++;
                    break;
                case 400:
                    cnt400++;
                    break;
            }
        }
        BigInteger cntOnly100 = BigInteger.valueOf(0);
        BigInteger cnt100_3And200_1 = BigInteger.valueOf(0);
        BigInteger cnt100_1And200_2 = BigInteger.valueOf(0);
        BigInteger cnt100And400 = BigInteger.valueOf(0);
        BigInteger cnt100And300 = BigInteger.valueOf(0);
        BigInteger cnt200And300 = BigInteger.valueOf(0);

        if(cnt100 >= 1 && cnt400>=1){
            cnt100And400 = (BigInteger.valueOf(cnt100)).multiply((BigInteger.valueOf(cnt400)));
        }

        if(cnt200 >= 1 && cnt300>=1){
            cnt200And300 = (BigInteger.valueOf(cnt200)).multiply((BigInteger.valueOf(cnt300)));
        }
        BigInteger total = cntOnly100.add(cnt100_3And200_1).add(cnt100_1And200_2)
                .add(cnt100And400).add(cnt100And300).add(cnt200And300);
        System.out.println(total);


    }

    public static BigInteger combination(int n, int r) {
        if (n < r || n < 0 || r < 0) {
            return BigInteger.ZERO;
        }
        BigInteger ans = BigInteger.valueOf(1);
        for (int i = 0; i < (n - r); i++) {
            ans = ans.multiply(BigInteger.valueOf(n - i));
        }
        for (int i = 0; i < (n - r); i++) {
            ans = ans.divide(BigInteger.valueOf(i + 1));
        }
        return ans;
    }

}
